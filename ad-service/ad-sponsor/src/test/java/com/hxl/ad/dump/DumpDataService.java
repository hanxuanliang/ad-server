package com.hxl.ad.dump;

import com.alibaba.fastjson.JSON;
import com.hxl.ad.DumpApplication;
import com.hxl.ad.constant.CommonStatus;
import com.hxl.ad.dao.AdPlanRepository;
import com.hxl.ad.dao.AdUnitRepository;
import com.hxl.ad.dao.CreativeRepository;
import com.hxl.ad.dao.association.AdUnitDistrictRepository;
import com.hxl.ad.dao.association.AdUnitItRepository;
import com.hxl.ad.dao.association.AdUnitKeywordRepository;
import com.hxl.ad.dao.association.CreativeUnitRepository;
import com.hxl.ad.dump.table.*;
import com.hxl.ad.entity.AdCreative;
import com.hxl.ad.entity.AdPlan;
import com.hxl.ad.entity.AdUnit;
import com.hxl.ad.entity.association.AdUnitDistrict;
import com.hxl.ad.entity.association.AdUnitIt;
import com.hxl.ad.entity.association.AdUnitKeyword;
import com.hxl.ad.entity.association.CreativeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: hanxuanliang
 * @Date: 2020/2/28 17:24
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DumpApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class DumpDataService {

    @Autowired
    private AdPlanRepository planRepository;
    @Autowired
    private AdUnitRepository unitRepository;
    @Autowired
    private CreativeRepository creativeRepository;
    @Autowired
    private CreativeUnitRepository creativeUnitRepository;
    @Autowired
    private AdUnitDistrictRepository districtRepository;
    @Autowired
    private AdUnitKeywordRepository KeywordRepository;
    @Autowired
    private AdUnitItRepository interestRepository;

    @Test
    public void dumpAdTableData() {
        dumpAdPlanTable(
                String.format("%s%s", DumpConstant.DATA_ROOT_DIR, DumpConstant.AD_PLAN)
        );
        dumpAdUnitTable(
                String.format("%s%s", DumpConstant.DATA_ROOT_DIR, DumpConstant.AD_UNIT)
        );
        dumpAdCreativeTable(
                String.format("%s%s", DumpConstant.DATA_ROOT_DIR, DumpConstant.AD_CREATIVE)
        );
        dumpAdCreativeUnitTable(
                String.format("%s%s", DumpConstant.DATA_ROOT_DIR, DumpConstant.AD_CREATIVE_UNIT)
        );
        dumpAdUnitDistrictTable(
                String.format("%s%s", DumpConstant.DATA_ROOT_DIR, DumpConstant.AD_UNIT_DISTRICT)
        );
        dumpAdUnitInterestTable(
                String.format("%s%s", DumpConstant.DATA_ROOT_DIR, DumpConstant.AD_UNIT_INTEREST)
        );
        dumpAdUnitKeywordable(
                String.format("%s%s", DumpConstant.DATA_ROOT_DIR, DumpConstant.AD_UNIT_KEYWORD)
        );
    }

    private void dumpAdPlanTable(String fileName) {
        List<AdPlan> adPlans = planRepository.findAllByPlanStatus(
                CommonStatus.VALID.getStatus()
        );
        if (CollectionUtils.isEmpty(adPlans)) {
            return;
        }
        List<AdPlanTable> planTables = new ArrayList<>();
        adPlans.forEach(p -> planTables.add(
                new AdPlanTable(p.getId(), p.getUserId(), p.getPlanStatus(),
                        p.getStartDate(), p.getEndDate())
        ));
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (AdPlanTable adPlanTable : planTables) {
                writer.write(JSON.toJSONString(planTables));
                writer.newLine();
            }
        } catch (IOException e) {
            log.error("dumpAdPlanTable error");
        }
    }

    private void dumpAdUnitTable(String fileName) {
        List<AdUnit> adUnits = unitRepository.findAllByUnitStatus(
                CommonStatus.VALID.getStatus()
        );
        if (CollectionUtils.isEmpty(adUnits)) {
            return;
        }
        List<AdUnitTable> unitTables = new ArrayList<>();
        adUnits.forEach(u -> unitTables.add(
                new AdUnitTable(u.getId(), u.getUnitStatus(), u.getPositionType(), u.getPlanId())
        ));
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (AdUnitTable unitTable : unitTables) {
                writer.write(JSON.toJSONString(unitTables));
                writer.newLine();
            }
        } catch (IOException e) {
            log.error("dumpAdPlanTable error");
        }
    }

    private void dumpAdCreativeTable(String fileName) {
        List<AdCreative> creatives = creativeRepository.findAll();
        if (CollectionUtils.isEmpty(creatives)) {
            return;
        }
        List<AdCreativeTable> creativeTables = new ArrayList<>();
        creatives.forEach(c -> creativeTables.add(
                new AdCreativeTable(c.getId(), c.getName(),
                        c.getType(), c.getMaterialType(), c.getHeight(), c.getWidth(),
                        c.getAuditStatus(), c.getUrl())
        ));
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (AdCreativeTable creativeTable : creativeTables) {
                writer.write(JSON.toJSONString(creativeTables));
                writer.newLine();
            }
        } catch (IOException e) {
            log.error("dumpAdUnitTable error");
        }
    }

    private void dumpAdUnitDistrictTable(String fileName) {
        List<AdUnitDistrict> unitDistricts = districtRepository.findAll();
        if (CollectionUtils.isEmpty(unitDistricts)) {
            return;
        }
        List<AdUnitDistrictTable> unitDistrictTables = new ArrayList<>();
        unitDistricts.forEach(d -> unitDistrictTables.add(
                new AdUnitDistrictTable(d.getUnitId(), d.getProvince(), d.getCity())
        ));
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (AdUnitDistrictTable unitDistrictTable : unitDistrictTables) {
                writer.write(JSON.toJSONString(unitDistrictTables));
                writer.newLine();
            }
        } catch (IOException e) {
            log.error("dumpAdUnitDistrictTable error");
        }
    }

    private void dumpAdCreativeUnitTable(String fileName) {
        List<CreativeUnit> creativeUnits = creativeUnitRepository.findAll();
        if (CollectionUtils.isEmpty(creativeUnits)) {
            return;
        }
        List<AdCreativeUnitTable> creativeUnitTables = new ArrayList<>();
        creativeUnits.forEach(c -> creativeUnitTables.add(
                new AdCreativeUnitTable(c.getCreativeId(), c.getUnitId())
        ));
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (AdCreativeUnitTable creativeUnitTable : creativeUnitTables) {
                writer.write(JSON.toJSONString(creativeUnitTables));
                writer.newLine();
            }
        } catch (IOException e) {
            log.error("dumpAdCreaticeUnitTable error");
        }
    }

    private void dumpAdUnitInterestTable(String fileName) {
        List<AdUnitIt> unitInterests = interestRepository.findAll();
        if (CollectionUtils.isEmpty(unitInterests)) {
            return;
        }
        List<AdUnitItTable> unitInterestTables = new ArrayList<>();
        unitInterests.forEach(i -> unitInterestTables.add(
                new AdUnitItTable(i.getId(), i.getItTag())
        ));
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (AdUnitItTable unitInterestTable : unitInterestTables) {
                writer.write(JSON.toJSONString(unitInterestTables));
                writer.newLine();
            }
        } catch (IOException e) {
            log.error("dumpAdUnitInterestTable error");
        }
    }

    private void dumpAdUnitKeywordable(String fileName) {
        List<AdUnitKeyword> unitKeywords = KeywordRepository.findAll();
        if (CollectionUtils.isEmpty(unitKeywords)) {
            return;
        }
        List<AdUnitKeywordTable> unitKeywordTables = new ArrayList<>();
        unitKeywords.forEach(i -> unitKeywordTables.add(
                new AdUnitKeywordTable(i.getUnitId(), i.getKeyword())
        ));
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (AdUnitKeywordTable unitKeywordTable : unitKeywordTables) {
                writer.write(JSON.toJSONString(unitKeywordTables));
                writer.newLine();
            }
        } catch (IOException e) {
            log.error("dumpAdUnitKeywordTable error");
        }
    }
}
