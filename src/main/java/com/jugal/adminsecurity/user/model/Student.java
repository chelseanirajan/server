package com.jugal.adminsecurity.user.model;

import com.jugal.adminsecurity.model.User;

import javax.persistence.*;
@Entity
@Table(name = "studentTable")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    @Column(name = "student_name")
    private  String name;
    private  String symbolNo;
    private String schoolName;
    private int rollNo;
    private String doB;
    private String fatherName;
    private String motherName;

    private float  englishTh;
    private float  englishPr;
    private float  nepaliTh;
    private float  nepaliPr;
    private float  mathTh;
    private float  scienceTh;
    private float  sciencePr;
    private float  socialTh;
    private float  SocialPr;
    private float  obtTh;
    private float  obtPr;
    private float  healthTh;
    private float  healthPr;
    private float  moralTh;
    private float  moralPr;
    private float  optTh;
    private float  optPr;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getDoB() {
        return doB;
    }

    public void setDoB(String doB) {
        this.doB = doB;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public float getEnglishTh() {
        return englishTh;
    }

    public void setEnglishTh(float englishTh) {
        this.englishTh = englishTh;
    }

    public float getEnglishPr() {
        return englishPr;
    }

    public void setEnglishPr(float englishPr) {
        this.englishPr = englishPr;
    }

    public float getNepaliTh() {
        return nepaliTh;
    }

    public void setNepaliTh(float nepaliTh) {
        this.nepaliTh = nepaliTh;
    }

    public float getNepaliPr() {
        return nepaliPr;
    }

    public void setNepaliPr(float nepaliPr) {
        this.nepaliPr = nepaliPr;
    }

    public float getMathTh() {
        return mathTh;
    }

    public void setMathTh(float mathTh) {
        this.mathTh = mathTh;
    }

    public float getScienceTh() {
        return scienceTh;
    }

    public void setScienceTh(float scienceTh) {
        this.scienceTh = scienceTh;
    }

    public float getSciencePr() {
        return sciencePr;
    }

    public void setSciencePr(float sciencePr) {
        this.sciencePr = sciencePr;
    }

    public float getSocialTh() {
        return socialTh;
    }

    public void setSocialTh(float socialTh) {
        this.socialTh = socialTh;
    }

    public float getSocialPr() {
        return SocialPr;
    }

    public void setSocialPr(float socialPr) {
        SocialPr = socialPr;
    }

    public float getObtTh() {
        return obtTh;
    }

    public void setObtTh(float obtTh) {
        this.obtTh = obtTh;
    }

    public float getObtPr() {
        return obtPr;
    }

    public void setObtPr(float obtPr) {
        this.obtPr = obtPr;
    }

    public float getHealthTh() {
        return healthTh;
    }

    public void setHealthTh(float healthTh) {
        this.healthTh = healthTh;
    }

    public float getHealthPr() {
        return healthPr;
    }

    public void setHealthPr(float healthPr) {
        this.healthPr = healthPr;
    }

    public float getMoralTh() {
        return moralTh;
    }

    public void setMoralTh(float moralTh) {
        this.moralTh = moralTh;
    }

    public float getMoralPr() {
        return moralPr;
    }

    public void setMoralPr(float moralPr) {
        this.moralPr = moralPr;
    }

    public float getOptTh() {
        return optTh;
    }

    public void setOptTh(float optTh) {
        this.optTh = optTh;
    }

    public float getOptPr() {
        return optPr;
    }

    public void setOptPr(float optPr) {
        this.optPr = optPr;
    }

    public String getSymbolNo() {
        return symbolNo;
    }

    public void setSymbolNo(String symbolNo) {
        this.symbolNo = symbolNo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", symbolNo='" + symbolNo + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", rollNo=" + rollNo +
                ", doB='" + doB + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", englishTh=" + englishTh +
                ", englishPr=" + englishPr +
                ", nepaliTh=" + nepaliTh +
                ", nepaliPr=" + nepaliPr +
                ", mathTh=" + mathTh +
                ", scienceTh=" + scienceTh +
                ", sciencePr=" + sciencePr +
                ", socialTh=" + socialTh +
                ", SocialPr=" + SocialPr +
                ", obtTh=" + obtTh +
                ", obtPr=" + obtPr +
                ", healthTh=" + healthTh +
                ", healthPr=" + healthPr +
                ", moralTh=" + moralTh +
                ", moralPr=" + moralPr +
                ", optTh=" + optTh +
                ", optPr=" + optPr +
                '}';
    }
}
