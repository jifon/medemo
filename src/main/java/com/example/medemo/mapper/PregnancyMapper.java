package com.example.medemo.mapper;

import com.example.medemo.dto.PregnancyDto;
import com.example.medemo.model.Pregnancy;

public class PregnancyMapper {

    public static Pregnancy DtoToEntity(PregnancyDto dto) {

        Pregnancy entity = new Pregnancy();
        entity.setPeculiarities_of_course_of_pregnancy_childbirth(dto.getPeculiarities_of_course_of_pregnancy_childbirth());
        entity.setSkin_and_mucous_membranes(dto.getSkin_and_mucous_membranes());
        entity.setThyroid(dto.getThyroid());
        entity.setMilk_glands(dto.getMilk_glands());
        entity.setPeripheral_lymph_nodes(dto.getPeripheral_lymph_nodes());
        entity.setRespiratory_system(dto.getRespiratory_system());
        entity.setBlood_pressure(dto.getBlood_pressure());
        entity.setDigestive_system(dto.getDigestive_system());
        entity.setUrinary_system(dto.getUrinary_system());
        entity.setEdema(dto.getEdema());
        entity.setBone_pelvis(dto.getBone_pelvis());
        entity.setUterine_fundus_height(dto.getUterine_fundus_height());
        entity.setFetal_heartbeat(dto.getFetal_heartbeat());
        entity.setExternal_genitalia(dto.getExternal_genitalia());
        entity.setExamination_of_cervix_in_mirrors(dto.getExamination_of_cervix_in_mirrors());
        entity.setBimanual_study(dto.getBimanual_study());
        entity.setVaginal_discharge(dto.getVaginal_discharge());
        entity.setProvisional_diagnosis(dto.getProvisional_diagnosis());
        entity.setRh_factor_pregnant(dto.getRh_factor_pregnant());
        entity.setRh_factor_partner(dto.getRh_factor_partner());
        entity.setTiter_rh_factor_in_twenty_eight_month(dto.getTiter_rh_factor_in_twenty_eight_month());
        entity.setBlood_hiv(dto.getBlood_hiv());
        entity.setBlood_hiv_parner(dto.getBlood_hiv_parner());
        entity.setDate_of_registration(dto.getDate_of_registration());
        entity.setCome_from_another_med_org(dto.getCome_from_another_med_org());
        entity.setGestational_age_by_last_menstruation_week(dto.getGestational_age_by_last_menstruation_week());
        entity.setGestational_age_by_ultrasound_week(dto.getGestational_age_by_ultrasound_week());
        entity.setEstimated_date_of_birth(dto.getEstimated_date_of_birth());
        entity.setTaken_after_twelve_weeks_of_pregnancy_reason(dto.getTaken_after_twelve_weeks_of_pregnancy_reason());
        entity.setFirst_visit_complaints(dto.getFirst_visit_complaints());
        entity.setFirst_visit_growth(dto.getFirst_visit_growth());
        entity.setFirst_visit_weight(dto.getFirst_visit_weight());
        entity.setBody_mass_index(dto.getBody_mass_index());
        entity.setReceived_basic_package_of_antenatal_services(dto.getReceived_basic_package_of_antenatal_services());
        entity.setBlood_type(dto.getBlood_type());
        entity.setPatient(dto.getPatient());
        entity.setDoctrs(dto.getDoctrs());
        entity.setAnamnesis(dto.getAnamnesis());
        entity.setLaboratoryResearches(dto.getLaboratoryResearches());
        entity.setAppointments(dto.getAppointments());

        return entity;
    }
    public static PregnancyDto EntityToDto(Pregnancy dto) {

        PregnancyDto entity = new PregnancyDto();

        dto.setPeculiarities_of_course_of_pregnancy_childbirth(entity.getPeculiarities_of_course_of_pregnancy_childbirth());
        dto.setSkin_and_mucous_membranes(entity.getSkin_and_mucous_membranes());
        dto.setThyroid(entity.getThyroid());
        dto.setMilk_glands(entity.getMilk_glands());
        dto.setPeripheral_lymph_nodes(entity.getPeripheral_lymph_nodes());
        dto.setRespiratory_system(entity.getRespiratory_system());
        dto.setBlood_pressure(entity.getBlood_pressure());
        dto.setDigestive_system(entity.getDigestive_system());
        dto.setUrinary_system(entity.getUrinary_system());
        dto.setEdema(entity.getEdema());
        dto.setBone_pelvis(entity.getBone_pelvis());
        dto.setUterine_fundus_height(entity.getUterine_fundus_height());
        dto.setFetal_heartbeat(entity.getFetal_heartbeat());
        dto.setExternal_genitalia(entity.getExternal_genitalia());
        dto.setExamination_of_cervix_in_mirrors(entity.getExamination_of_cervix_in_mirrors());
        dto.setBimanual_study(entity.getBimanual_study());
        dto.setVaginal_discharge(entity.getVaginal_discharge());
        dto.setProvisional_diagnosis(entity.getProvisional_diagnosis());
        dto.setRh_factor_pregnant(entity.getRh_factor_pregnant());
        dto.setRh_factor_partner(entity.getRh_factor_partner());
        dto.setTiter_rh_factor_in_twenty_eight_month(entity.getTiter_rh_factor_in_twenty_eight_month());
        dto.setBlood_hiv(entity.getBlood_hiv());
        dto.setBlood_hiv_parner(entity.getBlood_hiv_parner());
        dto.setDate_of_registration(entity.getDate_of_registration());
        dto.setCome_from_another_med_org(entity.getCome_from_another_med_org());
        dto.setGestational_age_by_last_menstruation_week(entity.getGestational_age_by_last_menstruation_week());
        dto.setGestational_age_by_ultrasound_week(entity.getGestational_age_by_ultrasound_week());
        dto.setEstimated_date_of_birth(entity.getEstimated_date_of_birth());
        dto.setTaken_after_twelve_weeks_of_pregnancy_reason(entity.getTaken_after_twelve_weeks_of_pregnancy_reason());
        dto.setFirst_visit_complaints(entity.getFirst_visit_complaints());
        dto.setFirst_visit_growth(entity.getFirst_visit_growth());
        dto.setFirst_visit_weight(entity.getFirst_visit_weight());
        dto.setBody_mass_index(entity.getBody_mass_index());
        dto.setReceived_basic_package_of_antenatal_services(entity.getReceived_basic_package_of_antenatal_services());
        dto.setBlood_type(entity.getBlood_type());
        dto.setPatient(entity.getPatient());
        dto.setDoctrs(entity.getDoctrs());
        dto.setAnamnesis(entity.getAnamnesis());
        dto.setLaboratoryResearches(entity.getLaboratoryResearches());
        dto.setAppointments(entity.getAppointments());

        return entity;
    }
}
