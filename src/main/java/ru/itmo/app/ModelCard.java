package ru.itmo.app;

public class ModelCard {
    private Integer id;
    private String last_name;
    private Integer first_name;
    private Integer patronymic;
    private String date_of_birth;
    private Integer gender;
    private Integer country;
    private Integer region;
    private String outdoors;

    private String date_of_commission;
    private String place_of_commission;

    private String date_of_initiation;
    private Integer office_of_initiation;
    private String name_of_initiation;

    private String date_of_preparing_report;
    private Integer office_of_preparing_report;
    private String name_of_preparing_report;
    private Integer id_article;

    private String date_of_decision;
    private String decision;
    private Integer office_of_decision;
    private String name_of_decision;
    private Integer punishment;
    private Integer sum;

    private String date_of_entry_into_force;
    private String date_sentence_enforcement;
    private Integer amount;

    public ModelCard(Integer id, String last_name, Integer first_name, Integer patronymic, String date_of_birth, Integer gender, Integer country, Integer region, String outdoors, String date_of_commission, String place_of_commission, String date_of_initiation, Integer office_of_initiation, String name_of_initiation, String date_of_preparing_report, Integer office_of_preparing_report, String name_of_preparing_report, Integer id_article, String date_of_decision, String decision, Integer office_of_decision, String name_of_decision, Integer punishment, Integer sum, String date_of_entry_into_force, String date_sentence_enforcement, Integer amount) {
        this.id = id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.patronymic = patronymic;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.country = country;
        this.region = region;
        this.outdoors = outdoors;
        this.date_of_commission = date_of_commission;
        this.place_of_commission = place_of_commission;
        this.date_of_initiation = date_of_initiation;
        this.office_of_initiation = office_of_initiation;
        this.name_of_initiation = name_of_initiation;
        this.date_of_preparing_report = date_of_preparing_report;
        this.office_of_preparing_report = office_of_preparing_report;
        this.name_of_preparing_report = name_of_preparing_report;
        this.id_article = id_article;
        this.date_of_decision = date_of_decision;
        this.decision = decision;
        this.office_of_decision = office_of_decision;
        this.name_of_decision = name_of_decision;
        this.punishment = punishment;
        this.sum = sum;
        this.date_of_entry_into_force = date_of_entry_into_force;
        this.date_sentence_enforcement = date_sentence_enforcement;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Integer getFirst_name() {
        return first_name;
    }

    public void setFirst_name(Integer first_name) {
        this.first_name = first_name;
    }

    public Integer getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(Integer patronymic) {
        this.patronymic = patronymic;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public String getOutdoors() {
        return outdoors;
    }

    public void setOutdoors(String outdoors) {
        this.outdoors = outdoors;
    }

    public String getDate_of_commission() {
        return date_of_commission;
    }

    public void setDate_of_commission(String date_of_commission) {
        this.date_of_commission = date_of_commission;
    }

    public String getPlace_of_commission() {
        return place_of_commission;
    }

    public void setPlace_of_commission(String place_of_commission) {
        this.place_of_commission = place_of_commission;
    }

    public String getDate_of_initiation() {
        return date_of_initiation;
    }

    public void setDate_of_initiation(String date_of_initiation) {
        this.date_of_initiation = date_of_initiation;
    }

    public Integer getOffice_of_initiation() {
        return office_of_initiation;
    }

    public void setOffice_of_initiation(Integer office_of_initiation) {
        this.office_of_initiation = office_of_initiation;
    }

    public String getName_of_initiation() {
        return name_of_initiation;
    }

    public void setName_of_initiation(String name_of_initiation) {
        this.name_of_initiation = name_of_initiation;
    }

    public String getDate_of_preparing_report() {
        return date_of_preparing_report;
    }

    public void setDate_of_preparing_report(String date_of_preparing_report) {
        this.date_of_preparing_report = date_of_preparing_report;
    }

    public Integer getOffice_of_preparing_report() {
        return office_of_preparing_report;
    }

    public void setOffice_of_preparing_report(Integer office_of_preparing_report) {
        this.office_of_preparing_report = office_of_preparing_report;
    }

    public String getName_of_preparing_report() {
        return name_of_preparing_report;
    }

    public void setName_of_preparing_report(String name_of_preparing_report) {
        this.name_of_preparing_report = name_of_preparing_report;
    }

    public Integer getId_article() {
        return id_article;
    }

    public void setId_article(Integer id_article) {
        this.id_article = id_article;
    }

    public String getDate_of_decision() {
        return date_of_decision;
    }

    public void setDate_of_decision(String date_of_decision) {
        this.date_of_decision = date_of_decision;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public Integer getOffice_of_decision() {
        return office_of_decision;
    }

    public void setOffice_of_decision(Integer office_of_decision) {
        this.office_of_decision = office_of_decision;
    }

    public String getName_of_decision() {
        return name_of_decision;
    }

    public void setName_of_decision(String name_of_decision) {
        this.name_of_decision = name_of_decision;
    }

    public Integer getPunishment() {
        return punishment;
    }

    public void setPunishment(Integer punishment) {
        this.punishment = punishment;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getDate_of_entry_into_force() {
        return date_of_entry_into_force;
    }

    public void setDate_of_entry_into_force(String date_of_entry_into_force) {
        this.date_of_entry_into_force = date_of_entry_into_force;
    }

    public String getDate_sentence_enforcement() {
        return date_sentence_enforcement;
    }

    public void setDate_sentence_enforcement(String date_sentence_enforcement) {
        this.date_sentence_enforcement = date_sentence_enforcement;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
