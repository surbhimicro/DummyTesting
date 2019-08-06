package com.blk.otto.pojo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"azureB2CId",
"appuserId",
"participantId",
"employmentStatus",
"employmentStatusEffectiveDate",
"emailAddress",
"retirementAge",
"salary",
"annualBonusAmount",
"jointLife",
"COLA",
"socialSecurity",
"maritalStatus",
"participantDOB",
"spouseDOB",
"alternateEmail"
})
public class UserProfile {

@JsonProperty("azureB2CId")
private String azureB2CId;
@JsonProperty("appuserId")
private String appuserId;
@JsonProperty("participantId")
private long participantId;
@JsonProperty("employmentStatus")
private String employmentStatus;
@JsonProperty("employmentStatusEffectiveDate")
private long employmentStatusEffectiveDate;
@JsonProperty("emailAddress")
private String emailAddress;
@JsonProperty("retirementAge")
private long retirementAge;
@JsonProperty("salary")
private long salary;
@JsonProperty("annualBonusAmount")
private long annualBonusAmount;
@JsonProperty("jointLife")
private boolean jointLife;
@JsonProperty("COLA")
private boolean COLA;
@JsonProperty("socialSecurity")
private boolean socialSecurity;
@JsonProperty("maritalStatus")
private String maritalStatus;
@JsonProperty("participantDOB")
private long participantDOB;
@JsonProperty("spouseDOB")
private long spouseDOB;
@JsonProperty("alternateEmail")
private String alternateEmail;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
* 
*/
public UserProfile() {
}

/**
* 
* @param spouseDOB
* @param azureB2CId
* @param cOLA
* @param alternateEmail
* @param retirementAge
* @param participantDOB
* @param participantId
* @param emailAddress
* @param maritalStatus
* @param appuserId
* @param socialSecurity
* @param salary
* @param annualBonusAmount
* @param jointLife
* @param employmentStatusEffectiveDate
* @param employmentStatus
*/
public UserProfile(String azureB2CId, String appuserId, long participantId, String employmentStatus, long employmentStatusEffectiveDate, String emailAddress, long retirementAge, long salary, long annualBonusAmount, boolean jointLife, boolean cOLA, boolean socialSecurity, String maritalStatus, long participantDOB, long spouseDOB, String alternateEmail) {
super();
this.azureB2CId = azureB2CId;
this.appuserId = appuserId;
this.participantId = participantId;
this.employmentStatus = employmentStatus;
this.employmentStatusEffectiveDate = employmentStatusEffectiveDate;
this.emailAddress = emailAddress;
this.retirementAge = retirementAge;
this.salary = salary;
this.annualBonusAmount = annualBonusAmount;
this.jointLife = jointLife;
this.COLA = cOLA;
this.socialSecurity = socialSecurity;
this.maritalStatus = maritalStatus;
this.participantDOB = participantDOB;
this.spouseDOB = spouseDOB;
this.alternateEmail = alternateEmail;
}

@JsonProperty("azureB2CId")
public String getAzureB2CId() {
return azureB2CId;
}

@JsonProperty("azureB2CId")
public void setAzureB2CId(String azureB2CId) {
this.azureB2CId = azureB2CId;
}

@JsonProperty("appuserId")
public String getAppuserId() {
return appuserId;
}

@JsonProperty("appuserId")
public void setAppuserId(String appuserId) {
this.appuserId = appuserId;
}

@JsonProperty("participantId")
public long getParticipantId() {
return participantId;
}

@JsonProperty("participantId")
public void setParticipantId(long participantId) {
this.participantId = participantId;
}

@JsonProperty("employmentStatus")
public String getEmploymentStatus() {
return employmentStatus;
}

@JsonProperty("employmentStatus")
public void setEmploymentStatus(String employmentStatus) {
this.employmentStatus = employmentStatus;
}

@JsonProperty("employmentStatusEffectiveDate")
public long getEmploymentStatusEffectiveDate() {
return employmentStatusEffectiveDate;
}

@JsonProperty("employmentStatusEffectiveDate")
public void setEmploymentStatusEffectiveDate(long employmentStatusEffectiveDate) {
this.employmentStatusEffectiveDate = employmentStatusEffectiveDate;
}

@JsonProperty("emailAddress")
public String getEmailAddress() {
return emailAddress;
}

@JsonProperty("emailAddress")
public void setEmailAddress(String emailAddress) {
this.emailAddress = emailAddress;
}

@JsonProperty("retirementAge")
public long getRetirementAge() {
return retirementAge;
}

@JsonProperty("retirementAge")
public void setRetirementAge(long retirementAge) {
this.retirementAge = retirementAge;
}

@JsonProperty("salary")
public long getSalary() {
return salary;
}

@JsonProperty("salary")
public void setSalary(long salary) {
this.salary = salary;
}

@JsonProperty("annualBonusAmount")
public long getAnnualBonusAmount() {
return annualBonusAmount;
}

@JsonProperty("annualBonusAmount")
public void setAnnualBonusAmount(long annualBonusAmount) {
this.annualBonusAmount = annualBonusAmount;
}

@JsonProperty("jointLife")
public boolean isJointLife() {
return jointLife;
}

@JsonProperty("jointLife")
public void setJointLife(boolean jointLife) {
this.jointLife = jointLife;
}

@JsonProperty("COLA")
public boolean isCOLA() {
return COLA;
}

@JsonProperty("COLA")
public void setCOLA(boolean cOLA) {
this.COLA = cOLA;
}

@JsonProperty("socialSecurity")
public boolean isSocialSecurity() {
return socialSecurity;
}

@JsonProperty("socialSecurity")
public void setSocialSecurity(boolean socialSecurity) {
this.socialSecurity = socialSecurity;
}

@JsonProperty("maritalStatus")
public String getMaritalStatus() {
return maritalStatus;
}

@JsonProperty("maritalStatus")
public void setMaritalStatus(String maritalStatus) {
this.maritalStatus = maritalStatus;
}

@JsonProperty("participantDOB")
public long getParticipantDOB() {
return participantDOB;
}

@JsonProperty("participantDOB")
public void setParticipantDOB(long participantDOB) {
this.participantDOB = participantDOB;
}

@JsonProperty("spouseDOB")
public long getSpouseDOB() {
return spouseDOB;
}

@JsonProperty("spouseDOB")
public void setSpouseDOB(long spouseDOB) {
this.spouseDOB = spouseDOB;
}

@JsonProperty("alternateEmail")
public String getAlternateEmail() {
return alternateEmail;
}

@JsonProperty("alternateEmail")
public void setAlternateEmail(String alternateEmail) {
this.alternateEmail = alternateEmail;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

@Override
public String toString() {
return new ToStringBuilder(this).append("azureB2CId", azureB2CId).append("appuserId", appuserId).append("participantId", participantId).append("employmentStatus", employmentStatus).append("employmentStatusEffectiveDate", employmentStatusEffectiveDate).append("emailAddress", emailAddress).append("retirementAge", retirementAge).append("salary", salary).append("annualBonusAmount", annualBonusAmount).append("jointLife", jointLife).append("C"
		+ "OLA", COLA).append("socialSecurity", socialSecurity).append("maritalStatus", maritalStatus).append("participantDOB", participantDOB).append("spouseDOB", spouseDOB).append("alternateEmail", alternateEmail).append("additionalProperties", additionalProperties).toString();
}

@Override
public int hashCode() {
return new HashCodeBuilder().append(spouseDOB).append(COLA).append(azureB2CId).append(alternateEmail).append(retirementAge).append(participantDOB).append(emailAddress).append(participantId).append(maritalStatus).append(appuserId).append(socialSecurity).append(additionalProperties).append(jointLife).append(annualBonusAmount).append(salary).append(employmentStatusEffectiveDate).append(employmentStatus).toHashCode();
}

@Override
public boolean equals(Object other) {
if (other == this) {
return true;
}
if ((other instanceof UserProfile) == false) {
return false;
}
UserProfile rhs = ((UserProfile) other);
return new EqualsBuilder().append(spouseDOB, rhs.spouseDOB).append(COLA, rhs.COLA).append(azureB2CId, rhs.azureB2CId).append(alternateEmail, rhs.alternateEmail).append(retirementAge, rhs.retirementAge).append(participantDOB, rhs.participantDOB).append(emailAddress, rhs.emailAddress).append(participantId, rhs.participantId).append(maritalStatus, rhs.maritalStatus).append(appuserId, rhs.appuserId).append(socialSecurity, rhs.socialSecurity).append(additionalProperties, rhs.additionalProperties).append(jointLife, rhs.jointLife).append(annualBonusAmount, rhs.annualBonusAmount).append(salary, rhs.salary).append(employmentStatusEffectiveDate, rhs.employmentStatusEffectiveDate).append(employmentStatus, rhs.employmentStatus).isEquals();
}

}
