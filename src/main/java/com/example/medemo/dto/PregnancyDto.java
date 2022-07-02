package com.example.medemo.dto;

import com.example.medemo.model.*;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
public class PregnancyDto {

//    private Long id;
    private String peculiarities_of_course_of_pregnancy_childbirth;
    private String skin_and_mucous_membranes;
    private String thyroid;
    private String milk_glands;
    private String peripheral_lymph_nodes;
    private String respiratory_system;
    private String blood_pressure;
    private String digestive_system;
    private String urinary_system;
    private String edema;
    private String bone_pelvis;
    private String uterine_fundus_height;
    private String fetal_heartbeat;
    private String external_genitalia;
    private String examination_of_cervix_in_mirrors;
    private String bimanual_study;
    private String vaginal_discharge;
    private String provisional_diagnosis;
    private String rh_factor_pregnant;
    private String rh_factor_partner;
    private String titer_rh_factor_in_twenty_eight_month;
    private String blood_hiv;
    private String blood_hiv_parner;
    private String date_of_registration;
    private String come_from_another_med_org;
    private String gestational_age_by_last_menstruation_week;
    private String gestational_age_by_ultrasound_week;
    private String estimated_date_of_birth;
    private String taken_after_twelve_weeks_of_pregnancy_reason;
    private String first_visit_complaints;
    private String first_visit_growth;
    private String first_visit_weight;
    private String body_mass_index;
    private String received_basic_package_of_antenatal_services;
    private String blood_type;
    private Patient patient;
    private Doctor doctrs;
    private Set<Anamnesis> anamnesis;
    private Set<LaboratoryResearch> laboratoryResearches;
    private Set<Appointment> appointments;








}
