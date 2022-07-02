package com.example.medemo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "pregnancies")
@Table(name = "pregnancies")
@Getter
@Setter
public class Pregnancy {
    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column(name = "peculiarities_of_course_of_pregnancy_childbirth", nullable = false)
    private String peculiarities_of_course_of_pregnancy_childbirth;
    @Column(name = "skin_and_mucous_membranes", nullable = false)
    private String skin_and_mucous_membranes;
    @Column(name = "thyroid", nullable = false)
    private String thyroid;
    @Column(name = "milk_glands", nullable = false)
    private String milk_glands;
    @Column(name = "peripheral_lymph_nodes", nullable = false)
    private String peripheral_lymph_nodes;
    @Column(name = "respiratory_system", nullable = false)
    private String respiratory_system;
    @Column(name = "blood_pressure", nullable = false)
    private String blood_pressure;
    @Column(name = "digestive_system", nullable = false)
    private String digestive_system;
    @Column(name = "urinary_system", nullable = false)
    private String urinary_system;
    @Column(name = "edema", nullable = false)
    private String edema;
    @Column(name = "bone_pelvis", nullable = false)
    private String bone_pelvis;
    @Column(name = "uterine_fundus_height", nullable = false)
    private String uterine_fundus_height;
    @Column(name = "fetal_heartbeat", nullable = false)
    private String fetal_heartbeat;
    @Column(name = "external_genitalia", nullable = false)
    private String external_genitalia;
    @Column(name = "examination_of_cervix_in_mirrors", nullable = false)
    private String examination_of_cervix_in_mirrors;
    @Column(name = "bimanual_study", nullable = false)
    private String bimanual_study;
    @Column(name = "vaginal_discharge", nullable = false)
    private String vaginal_discharge;
    @Column(name = "provisional_diagnosis", nullable = false)
    private String provisional_diagnosis;
    @Column(name = "rh_factor_pregnant", nullable = false)
    private String rh_factor_pregnant;
    @Column(name = "rh_factor_partner", nullable = false)
    private String rh_factor_partner;
    @Column(name = "titer_rh_factor_in_twenty_eight_month", nullable = false)
    private String titer_rh_factor_in_twenty_eight_month;
    @Column(name = "blood_hiv", nullable = false)
    private String blood_hiv;
    @Column(name = "blood_hiv_parner", nullable = false)
    private String blood_hiv_parner;
    @Column(name = "date_of_registration", nullable = false)
    private String date_of_registration;
    @Column(name = "come_from_another_med_org", nullable = false)
    private String come_from_another_med_org;
    @Column(name = "gestational_age_by_last_menstruation_week", nullable = false)
    private String gestational_age_by_last_menstruation_week;
    @Column(name = "gestational_age_by_ultrasound_week", nullable = false)
    private String gestational_age_by_ultrasound_week;
    @Column(name = "estimated_date_of_birth", nullable = false)
    private String estimated_date_of_birth;
    @Column(name = "taken_after_twelve_weeks_of_pregnancy_reason", nullable = false)
    private String taken_after_twelve_weeks_of_pregnancy_reason;
    @Column(name = "first_visit_complaints", nullable = false)
    private String first_visit_complaints;
    @Column(name = "first_visit_growth", nullable = false)
    private String first_visit_growth;
    @Column(name = "first_visit_weight", nullable = false)
    private String first_visit_weight;
    @Column(name = "body_mass_index", nullable = false)
    private String body_mass_index;
    @Column(name = "received_basic_package_of_antenatal_services", nullable = false)
    private String received_basic_package_of_antenatal_services;
    @Column(name = "blood_type", nullable = false)
    private String blood_type;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctrs;

    @OneToMany(mappedBy="pregnancy")
    private Set<Anamnesis> anamnesis;


    @OneToMany(mappedBy="pregnancy")
    private Set<LaboratoryResearch> laboratoryResearches;

    @OneToMany(mappedBy="pregnancy")
    private Set<Appointment> appointments;





















}
