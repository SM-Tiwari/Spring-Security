
package com.gnv.vnm.selfcare.core.adapter.vasman.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.gnv.vnm.selfcare.core.adapter.vasman.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _VasProductDetailAlias_QNAME = new QName("http://vasman.elcom.com", "alias_");
    private final static QName _VasProductDetailIsdn_QNAME = new QName("http://vasman.elcom.com", "isdn");
    private final static QName _VasProductDetailTitle_QNAME = new QName("http://vasman.elcom.com", "title");
    private final static QName _BalanceRequestBalanceName_QNAME = new QName("http://vasman.elcom.com", "balanceName");
    private final static QName _TerminateDetailCause_QNAME = new QName("http://vasman.elcom.com", "cause");
    private final static QName _TerminateDetailDescription_QNAME = new QName("http://vasman.elcom.com", "description");
    private final static QName _ProvisioningCampaignReqNVasID_QNAME = new QName("http://vasman.elcom.com", "NVasID");
    private final static QName _ProvisioningCampaignReqSDescription_QNAME = new QName("http://vasman.elcom.com", "SDescription");
    private final static QName _ProvisioningCampaignReqMdn_QNAME = new QName("http://vasman.elcom.com", "mdn");
    private final static QName _ProvisioningCampaignReqPass_QNAME = new QName("http://vasman.elcom.com", "pass");
    private final static QName _ProvisioningCampaignReqUser_QNAME = new QName("http://vasman.elcom.com", "user");
    private final static QName _VasDetailRespErrorCode_QNAME = new QName("http://vasman.elcom.com", "errorCode");
    private final static QName _VasDetailRespErrorDetail_QNAME = new QName("http://vasman.elcom.com", "errorDetail");
    private final static QName _VasDetailRespVasPro_QNAME = new QName("http://vasman.elcom.com", "vasPro");
    private final static QName _ProvisioningDynamicServiceReqListBalance_QNAME = new QName("http://vasman.elcom.com", "listBalance");
    private final static QName _ProvisioningDynamicServiceReqVasID_QNAME = new QName("http://vasman.elcom.com", "vasID");
    private final static QName _MemberManagementRespMembers_QNAME = new QName("http://vasman.elcom.com", "members");
    private final static QName _MemberManagementReqAction_QNAME = new QName("http://vasman.elcom.com", "action");
    private final static QName _TerminalAllVasRespVasTerDetailList_QNAME = new QName("http://vasman.elcom.com", "vasTerDetailList");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.gnv.vnm.selfcare.core.adapter.vasman.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TerminateAllVas }
     * 
     */
    public TerminateAllVas createTerminateAllVas() {
        return new TerminateAllVas();
    }

    /**
     * Create an instance of {@link CheckAllVasStatusReq }
     * 
     */
    public CheckAllVasStatusReq createCheckAllVasStatusReq() {
        return new CheckAllVasStatusReq();
    }

    /**
     * Create an instance of {@link TerminateAllVasResponse }
     * 
     */
    public TerminateAllVasResponse createTerminateAllVasResponse() {
        return new TerminateAllVasResponse();
    }

    /**
     * Create an instance of {@link TerminalAllVasResp }
     * 
     */
    public TerminalAllVasResp createTerminalAllVasResp() {
        return new TerminalAllVasResp();
    }

    /**
     * Create an instance of {@link MemberManagement }
     * 
     */
    public MemberManagement createMemberManagement() {
        return new MemberManagement();
    }

    /**
     * Create an instance of {@link MemberManagementReq }
     * 
     */
    public MemberManagementReq createMemberManagementReq() {
        return new MemberManagementReq();
    }

    /**
     * Create an instance of {@link MemberManagementResponse }
     * 
     */
    public MemberManagementResponse createMemberManagementResponse() {
        return new MemberManagementResponse();
    }

    /**
     * Create an instance of {@link MemberManagementResp }
     * 
     */
    public MemberManagementResp createMemberManagementResp() {
        return new MemberManagementResp();
    }

    /**
     * Create an instance of {@link DynamicServiceProvisioning }
     * 
     */
    public DynamicServiceProvisioning createDynamicServiceProvisioning() {
        return new DynamicServiceProvisioning();
    }

    /**
     * Create an instance of {@link ProvisioningDynamicServiceReq }
     * 
     */
    public ProvisioningDynamicServiceReq createProvisioningDynamicServiceReq() {
        return new ProvisioningDynamicServiceReq();
    }

    /**
     * Create an instance of {@link DynamicServiceProvisioningResponse }
     * 
     */
    public DynamicServiceProvisioningResponse createDynamicServiceProvisioningResponse() {
        return new DynamicServiceProvisioningResponse();
    }

    /**
     * Create an instance of {@link ProvisioningResp }
     * 
     */
    public ProvisioningResp createProvisioningResp() {
        return new ProvisioningResp();
    }

    /**
     * Create an instance of {@link VasDetail }
     * 
     */
    public VasDetail createVasDetail() {
        return new VasDetail();
    }

    /**
     * Create an instance of {@link CheckVasStatusReq }
     * 
     */
    public CheckVasStatusReq createCheckVasStatusReq() {
        return new CheckVasStatusReq();
    }

    /**
     * Create an instance of {@link VasDetailResponse }
     * 
     */
    public VasDetailResponse createVasDetailResponse() {
        return new VasDetailResponse();
    }

    /**
     * Create an instance of {@link VasDetailResp }
     * 
     */
    public VasDetailResp createVasDetailResp() {
        return new VasDetailResp();
    }

    /**
     * Create an instance of {@link ProvisioningWithCampaign }
     * 
     */
    public ProvisioningWithCampaign createProvisioningWithCampaign() {
        return new ProvisioningWithCampaign();
    }

    /**
     * Create an instance of {@link ProvisioningCampaignReq }
     * 
     */
    public ProvisioningCampaignReq createProvisioningCampaignReq() {
        return new ProvisioningCampaignReq();
    }

    /**
     * Create an instance of {@link ProvisioningWithCampaignResponse }
     * 
     */
    public ProvisioningWithCampaignResponse createProvisioningWithCampaignResponse() {
        return new ProvisioningWithCampaignResponse();
    }

    /**
     * Create an instance of {@link ArrayOfTerminateDetail }
     * 
     */
    public ArrayOfTerminateDetail createArrayOfTerminateDetail() {
        return new ArrayOfTerminateDetail();
    }

    /**
     * Create an instance of {@link TerminateDetail }
     * 
     */
    public TerminateDetail createTerminateDetail() {
        return new TerminateDetail();
    }

    /**
     * Create an instance of {@link ArrayOfString }
     * 
     */
    public ArrayOfString createArrayOfString() {
        return new ArrayOfString();
    }

    /**
     * Create an instance of {@link ArrayOfBalanceRequest }
     * 
     */
    public ArrayOfBalanceRequest createArrayOfBalanceRequest() {
        return new ArrayOfBalanceRequest();
    }

    /**
     * Create an instance of {@link BalanceRequest }
     * 
     */
    public BalanceRequest createBalanceRequest() {
        return new BalanceRequest();
    }

    /**
     * Create an instance of {@link ArrayOfVasProductDetail }
     * 
     */
    public ArrayOfVasProductDetail createArrayOfVasProductDetail() {
        return new ArrayOfVasProductDetail();
    }

    /**
     * Create an instance of {@link VasProductDetail }
     * 
     */
    public VasProductDetail createVasProductDetail() {
        return new VasProductDetail();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "alias_", scope = VasProductDetail.class)
    public JAXBElement<String> createVasProductDetailAlias(String value) {
        return new JAXBElement<String>(_VasProductDetailAlias_QNAME, String.class, VasProductDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "isdn", scope = VasProductDetail.class)
    public JAXBElement<String> createVasProductDetailIsdn(String value) {
        return new JAXBElement<String>(_VasProductDetailIsdn_QNAME, String.class, VasProductDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "title", scope = VasProductDetail.class)
    public JAXBElement<String> createVasProductDetailTitle(String value) {
        return new JAXBElement<String>(_VasProductDetailTitle_QNAME, String.class, VasProductDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "balanceName", scope = BalanceRequest.class)
    public JAXBElement<String> createBalanceRequestBalanceName(String value) {
        return new JAXBElement<String>(_BalanceRequestBalanceName_QNAME, String.class, BalanceRequest.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "cause", scope = TerminateDetail.class)
    public JAXBElement<String> createTerminateDetailCause(String value) {
        return new JAXBElement<String>(_TerminateDetailCause_QNAME, String.class, TerminateDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "description", scope = TerminateDetail.class)
    public JAXBElement<String> createTerminateDetailDescription(String value) {
        return new JAXBElement<String>(_TerminateDetailDescription_QNAME, String.class, TerminateDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "isdn", scope = TerminateDetail.class)
    public JAXBElement<String> createTerminateDetailIsdn(String value) {
        return new JAXBElement<String>(_VasProductDetailIsdn_QNAME, String.class, TerminateDetail.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "NVasID", scope = ProvisioningCampaignReq.class)
    public JAXBElement<String> createProvisioningCampaignReqNVasID(String value) {
        return new JAXBElement<String>(_ProvisioningCampaignReqNVasID_QNAME, String.class, ProvisioningCampaignReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "SDescription", scope = ProvisioningCampaignReq.class)
    public JAXBElement<String> createProvisioningCampaignReqSDescription(String value) {
        return new JAXBElement<String>(_ProvisioningCampaignReqSDescription_QNAME, String.class, ProvisioningCampaignReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "mdn", scope = ProvisioningCampaignReq.class)
    public JAXBElement<String> createProvisioningCampaignReqMdn(String value) {
        return new JAXBElement<String>(_ProvisioningCampaignReqMdn_QNAME, String.class, ProvisioningCampaignReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "pass", scope = ProvisioningCampaignReq.class)
    public JAXBElement<String> createProvisioningCampaignReqPass(String value) {
        return new JAXBElement<String>(_ProvisioningCampaignReqPass_QNAME, String.class, ProvisioningCampaignReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "user", scope = ProvisioningCampaignReq.class)
    public JAXBElement<String> createProvisioningCampaignReqUser(String value) {
        return new JAXBElement<String>(_ProvisioningCampaignReqUser_QNAME, String.class, ProvisioningCampaignReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "errorCode", scope = VasDetailResp.class)
    public JAXBElement<String> createVasDetailRespErrorCode(String value) {
        return new JAXBElement<String>(_VasDetailRespErrorCode_QNAME, String.class, VasDetailResp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "errorDetail", scope = VasDetailResp.class)
    public JAXBElement<String> createVasDetailRespErrorDetail(String value) {
        return new JAXBElement<String>(_VasDetailRespErrorDetail_QNAME, String.class, VasDetailResp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "mdn", scope = VasDetailResp.class)
    public JAXBElement<String> createVasDetailRespMdn(String value) {
        return new JAXBElement<String>(_ProvisioningCampaignReqMdn_QNAME, String.class, VasDetailResp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfVasProductDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "vasPro", scope = VasDetailResp.class)
    public JAXBElement<ArrayOfVasProductDetail> createVasDetailRespVasPro(ArrayOfVasProductDetail value) {
        return new JAXBElement<ArrayOfVasProductDetail>(_VasDetailRespVasPro_QNAME, ArrayOfVasProductDetail.class, VasDetailResp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "mdn", scope = CheckVasStatusReq.class)
    public JAXBElement<String> createCheckVasStatusReqMdn(String value) {
        return new JAXBElement<String>(_ProvisioningCampaignReqMdn_QNAME, String.class, CheckVasStatusReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "pass", scope = CheckVasStatusReq.class)
    public JAXBElement<String> createCheckVasStatusReqPass(String value) {
        return new JAXBElement<String>(_ProvisioningCampaignReqPass_QNAME, String.class, CheckVasStatusReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "user", scope = CheckVasStatusReq.class)
    public JAXBElement<String> createCheckVasStatusReqUser(String value) {
        return new JAXBElement<String>(_ProvisioningCampaignReqUser_QNAME, String.class, CheckVasStatusReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "errorCode", scope = ProvisioningResp.class)
    public JAXBElement<String> createProvisioningRespErrorCode(String value) {
        return new JAXBElement<String>(_VasDetailRespErrorCode_QNAME, String.class, ProvisioningResp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "errorDetail", scope = ProvisioningResp.class)
    public JAXBElement<String> createProvisioningRespErrorDetail(String value) {
        return new JAXBElement<String>(_VasDetailRespErrorDetail_QNAME, String.class, ProvisioningResp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "mdn", scope = ProvisioningResp.class)
    public JAXBElement<String> createProvisioningRespMdn(String value) {
        return new JAXBElement<String>(_ProvisioningCampaignReqMdn_QNAME, String.class, ProvisioningResp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "SDescription", scope = ProvisioningDynamicServiceReq.class)
    public JAXBElement<String> createProvisioningDynamicServiceReqSDescription(String value) {
        return new JAXBElement<String>(_ProvisioningCampaignReqSDescription_QNAME, String.class, ProvisioningDynamicServiceReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfBalanceRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "listBalance", scope = ProvisioningDynamicServiceReq.class)
    public JAXBElement<ArrayOfBalanceRequest> createProvisioningDynamicServiceReqListBalance(ArrayOfBalanceRequest value) {
        return new JAXBElement<ArrayOfBalanceRequest>(_ProvisioningDynamicServiceReqListBalance_QNAME, ArrayOfBalanceRequest.class, ProvisioningDynamicServiceReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "mdn", scope = ProvisioningDynamicServiceReq.class)
    public JAXBElement<String> createProvisioningDynamicServiceReqMdn(String value) {
        return new JAXBElement<String>(_ProvisioningCampaignReqMdn_QNAME, String.class, ProvisioningDynamicServiceReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "pass", scope = ProvisioningDynamicServiceReq.class)
    public JAXBElement<String> createProvisioningDynamicServiceReqPass(String value) {
        return new JAXBElement<String>(_ProvisioningCampaignReqPass_QNAME, String.class, ProvisioningDynamicServiceReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "user", scope = ProvisioningDynamicServiceReq.class)
    public JAXBElement<String> createProvisioningDynamicServiceReqUser(String value) {
        return new JAXBElement<String>(_ProvisioningCampaignReqUser_QNAME, String.class, ProvisioningDynamicServiceReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "vasID", scope = ProvisioningDynamicServiceReq.class)
    public JAXBElement<String> createProvisioningDynamicServiceReqVasID(String value) {
        return new JAXBElement<String>(_ProvisioningDynamicServiceReqVasID_QNAME, String.class, ProvisioningDynamicServiceReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "errorCode", scope = MemberManagementResp.class)
    public JAXBElement<String> createMemberManagementRespErrorCode(String value) {
        return new JAXBElement<String>(_VasDetailRespErrorCode_QNAME, String.class, MemberManagementResp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "errorDetail", scope = MemberManagementResp.class)
    public JAXBElement<String> createMemberManagementRespErrorDetail(String value) {
        return new JAXBElement<String>(_VasDetailRespErrorDetail_QNAME, String.class, MemberManagementResp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "mdn", scope = MemberManagementResp.class)
    public JAXBElement<String> createMemberManagementRespMdn(String value) {
        return new JAXBElement<String>(_ProvisioningCampaignReqMdn_QNAME, String.class, MemberManagementResp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfString }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "members", scope = MemberManagementResp.class)
    public JAXBElement<ArrayOfString> createMemberManagementRespMembers(ArrayOfString value) {
        return new JAXBElement<ArrayOfString>(_MemberManagementRespMembers_QNAME, ArrayOfString.class, MemberManagementResp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "NVasID", scope = MemberManagementReq.class)
    public JAXBElement<String> createMemberManagementReqNVasID(String value) {
        return new JAXBElement<String>(_ProvisioningCampaignReqNVasID_QNAME, String.class, MemberManagementReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "SDescription", scope = MemberManagementReq.class)
    public JAXBElement<String> createMemberManagementReqSDescription(String value) {
        return new JAXBElement<String>(_ProvisioningCampaignReqSDescription_QNAME, String.class, MemberManagementReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "action", scope = MemberManagementReq.class)
    public JAXBElement<String> createMemberManagementReqAction(String value) {
        return new JAXBElement<String>(_MemberManagementReqAction_QNAME, String.class, MemberManagementReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "mdn", scope = MemberManagementReq.class)
    public JAXBElement<String> createMemberManagementReqMdn(String value) {
        return new JAXBElement<String>(_ProvisioningCampaignReqMdn_QNAME, String.class, MemberManagementReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfString }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "members", scope = MemberManagementReq.class)
    public JAXBElement<ArrayOfString> createMemberManagementReqMembers(ArrayOfString value) {
        return new JAXBElement<ArrayOfString>(_MemberManagementRespMembers_QNAME, ArrayOfString.class, MemberManagementReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "pass", scope = MemberManagementReq.class)
    public JAXBElement<String> createMemberManagementReqPass(String value) {
        return new JAXBElement<String>(_ProvisioningCampaignReqPass_QNAME, String.class, MemberManagementReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "user", scope = MemberManagementReq.class)
    public JAXBElement<String> createMemberManagementReqUser(String value) {
        return new JAXBElement<String>(_ProvisioningCampaignReqUser_QNAME, String.class, MemberManagementReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "errorCode", scope = TerminalAllVasResp.class)
    public JAXBElement<String> createTerminalAllVasRespErrorCode(String value) {
        return new JAXBElement<String>(_VasDetailRespErrorCode_QNAME, String.class, TerminalAllVasResp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "errorDetail", scope = TerminalAllVasResp.class)
    public JAXBElement<String> createTerminalAllVasRespErrorDetail(String value) {
        return new JAXBElement<String>(_VasDetailRespErrorDetail_QNAME, String.class, TerminalAllVasResp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "mdn", scope = TerminalAllVasResp.class)
    public JAXBElement<String> createTerminalAllVasRespMdn(String value) {
        return new JAXBElement<String>(_ProvisioningCampaignReqMdn_QNAME, String.class, TerminalAllVasResp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfTerminateDetail }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "vasTerDetailList", scope = TerminalAllVasResp.class)
    public JAXBElement<ArrayOfTerminateDetail> createTerminalAllVasRespVasTerDetailList(ArrayOfTerminateDetail value) {
        return new JAXBElement<ArrayOfTerminateDetail>(_TerminalAllVasRespVasTerDetailList_QNAME, ArrayOfTerminateDetail.class, TerminalAllVasResp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "mdn", scope = CheckAllVasStatusReq.class)
    public JAXBElement<String> createCheckAllVasStatusReqMdn(String value) {
        return new JAXBElement<String>(_ProvisioningCampaignReqMdn_QNAME, String.class, CheckAllVasStatusReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "pass", scope = CheckAllVasStatusReq.class)
    public JAXBElement<String> createCheckAllVasStatusReqPass(String value) {
        return new JAXBElement<String>(_ProvisioningCampaignReqPass_QNAME, String.class, CheckAllVasStatusReq.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vasman.elcom.com", name = "user", scope = CheckAllVasStatusReq.class)
    public JAXBElement<String> createCheckAllVasStatusReqUser(String value) {
        return new JAXBElement<String>(_ProvisioningCampaignReqUser_QNAME, String.class, CheckAllVasStatusReq.class, value);
    }

}
