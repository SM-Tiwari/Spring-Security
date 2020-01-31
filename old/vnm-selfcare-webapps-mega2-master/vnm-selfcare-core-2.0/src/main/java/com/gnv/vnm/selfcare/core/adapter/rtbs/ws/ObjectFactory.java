
package com.gnv.vnm.selfcare.core.adapter.rtbs.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.gnv.vnm.selfcare.core.adapter.rtbs.ws package. 
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

    private final static QName _VersionInfoHeader_QNAME = new QName("http://comverse-in.com/prepaid/ccws", "VersionInfoHeader");
    private final static QName _MTRDataArray_QNAME = new QName("http://comverse-in.com/prepaid/ccws", "MTRDataArray");
    private final static QName _SourceInfo_QNAME = new QName("http://comverse-in.com/prepaid/ccws", "SourceInfo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.gnv.vnm.selfcare.core.adapter.rtbs.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DiameterOCSHistory }
     * 
     */
    public DiameterOCSHistory createDiameterOCSHistory() {
        return new DiameterOCSHistory();
    }

    /**
     * Create an instance of {@link OSAHistory }
     * 
     */
    public OSAHistory createOSAHistory() {
        return new OSAHistory();
    }

    /**
     * Create an instance of {@link RechargeHistory }
     * 
     */
    public RechargeHistory createRechargeHistory() {
        return new RechargeHistory();
    }

    /**
     * Create an instance of {@link MonetaryTransactionRecord }
     * 
     */
    public MonetaryTransactionRecord createMonetaryTransactionRecord() {
        return new MonetaryTransactionRecord();
    }

    /**
     * Create an instance of {@link CallHistory }
     * 
     */
    public CallHistory createCallHistory() {
        return new CallHistory();
    }

    /**
     * Create an instance of {@link SubscriberMainBase }
     * 
     */
    public SubscriberMainBase createSubscriberMainBase() {
        return new SubscriberMainBase();
    }

    /**
     * Create an instance of {@link SubscriberInfo }
     * 
     */
    public SubscriberInfo createSubscriberInfo() {
        return new SubscriberInfo();
    }

    /**
     * Create an instance of {@link ClassOfService }
     * 
     */
    public ClassOfService createClassOfService() {
        return new ClassOfService();
    }

    /**
     * Create an instance of {@link DiscountPlan }
     * 
     */
    public DiscountPlan createDiscountPlan() {
        return new DiscountPlan();
    }

    /**
     * Create an instance of {@link BonusPlan }
     * 
     */
    public BonusPlan createBonusPlan() {
        return new BonusPlan();
    }

    /**
     * Create an instance of {@link ClientCache }
     * 
     */
    public ClientCache createClientCache() {
        return new ClientCache();
    }

    /**
     * Create an instance of {@link GetVersionId }
     * 
     */
    public GetVersionId createGetVersionId() {
        return new GetVersionId();
    }

    /**
     * Create an instance of {@link GetVersionIdResponse }
     * 
     */
    public GetVersionIdResponse createGetVersionIdResponse() {
        return new GetVersionIdResponse();
    }

    /**
     * Create an instance of {@link VersionInfoHeader }
     * 
     */
    public VersionInfoHeader createVersionInfoHeader() {
        return new VersionInfoHeader();
    }

    /**
     * Create an instance of {@link GetCache }
     * 
     */
    public GetCache createGetCache() {
        return new GetCache();
    }

    /**
     * Create an instance of {@link GetCacheResponse }
     * 
     */
    public GetCacheResponse createGetCacheResponse() {
        return new GetCacheResponse();
    }

    /**
     * Create an instance of {@link GetCacheEx }
     * 
     */
    public GetCacheEx createGetCacheEx() {
        return new GetCacheEx();
    }

    /**
     * Create an instance of {@link GetCacheExResponse }
     * 
     */
    public GetCacheExResponse createGetCacheExResponse() {
        return new GetCacheExResponse();
    }

    /**
     * Create an instance of {@link GetNonVersionCache }
     * 
     */
    public GetNonVersionCache createGetNonVersionCache() {
        return new GetNonVersionCache();
    }

    /**
     * Create an instance of {@link GetNonVersionCacheResponse }
     * 
     */
    public GetNonVersionCacheResponse createGetNonVersionCacheResponse() {
        return new GetNonVersionCacheResponse();
    }

    /**
     * Create an instance of {@link NonVersionCache }
     * 
     */
    public NonVersionCache createNonVersionCache() {
        return new NonVersionCache();
    }

    /**
     * Create an instance of {@link GetLocations }
     * 
     */
    public GetLocations createGetLocations() {
        return new GetLocations();
    }

    /**
     * Create an instance of {@link GetLocationsResponse }
     * 
     */
    public GetLocationsResponse createGetLocationsResponse() {
        return new GetLocationsResponse();
    }

    /**
     * Create an instance of {@link ArrayOfString }
     * 
     */
    public ArrayOfString createArrayOfString() {
        return new ArrayOfString();
    }

    /**
     * Create an instance of {@link ChangePassword }
     * 
     */
    public ChangePassword createChangePassword() {
        return new ChangePassword();
    }

    /**
     * Create an instance of {@link ChangePasswordResponse }
     * 
     */
    public ChangePasswordResponse createChangePasswordResponse() {
        return new ChangePasswordResponse();
    }

    /**
     * Create an instance of {@link GetRoles }
     * 
     */
    public GetRoles createGetRoles() {
        return new GetRoles();
    }

    /**
     * Create an instance of {@link GetRolesResponse }
     * 
     */
    public GetRolesResponse createGetRolesResponse() {
        return new GetRolesResponse();
    }

    /**
     * Create an instance of {@link RetrieveVoucherByBatchSerial }
     * 
     */
    public RetrieveVoucherByBatchSerial createRetrieveVoucherByBatchSerial() {
        return new RetrieveVoucherByBatchSerial();
    }

    /**
     * Create an instance of {@link RetrieveVoucherByBatchSerialResponse }
     * 
     */
    public RetrieveVoucherByBatchSerialResponse createRetrieveVoucherByBatchSerialResponse() {
        return new RetrieveVoucherByBatchSerialResponse();
    }

    /**
     * Create an instance of {@link VoucherEntity }
     * 
     */
    public VoucherEntity createVoucherEntity() {
        return new VoucherEntity();
    }

    /**
     * Create an instance of {@link RetrieveVoucherBySecretCode }
     * 
     */
    public RetrieveVoucherBySecretCode createRetrieveVoucherBySecretCode() {
        return new RetrieveVoucherBySecretCode();
    }

    /**
     * Create an instance of {@link RetrieveVoucherBySecretCodeResponse }
     * 
     */
    public RetrieveVoucherBySecretCodeResponse createRetrieveVoucherBySecretCodeResponse() {
        return new RetrieveVoucherBySecretCodeResponse();
    }

    /**
     * Create an instance of {@link DeleteVoucher }
     * 
     */
    public DeleteVoucher createDeleteVoucher() {
        return new DeleteVoucher();
    }

    /**
     * Create an instance of {@link DeleteVoucherResponse }
     * 
     */
    public DeleteVoucherResponse createDeleteVoucherResponse() {
        return new DeleteVoucherResponse();
    }

    /**
     * Create an instance of {@link ModifyVoucher }
     * 
     */
    public ModifyVoucher createModifyVoucher() {
        return new ModifyVoucher();
    }

    /**
     * Create an instance of {@link ModifyVoucherResponse }
     * 
     */
    public ModifyVoucherResponse createModifyVoucherResponse() {
        return new ModifyVoucherResponse();
    }

    /**
     * Create an instance of {@link UseVoucher }
     * 
     */
    public UseVoucher createUseVoucher() {
        return new UseVoucher();
    }

    /**
     * Create an instance of {@link UseVoucherResponse }
     * 
     */
    public UseVoucherResponse createUseVoucherResponse() {
        return new UseVoucherResponse();
    }

    /**
     * Create an instance of {@link CreateVoucher }
     * 
     */
    public CreateVoucher createCreateVoucher() {
        return new CreateVoucher();
    }

    /**
     * Create an instance of {@link CreateVoucherResponse }
     * 
     */
    public CreateVoucherResponse createCreateVoucherResponse() {
        return new CreateVoucherResponse();
    }

    /**
     * Create an instance of {@link ModifySubscriber }
     * 
     */
    public ModifySubscriber createModifySubscriber() {
        return new ModifySubscriber();
    }

    /**
     * Create an instance of {@link SubscriberModify }
     * 
     */
    public SubscriberModify createSubscriberModify() {
        return new SubscriberModify();
    }

    /**
     * Create an instance of {@link ModifySubscriberResponse }
     * 
     */
    public ModifySubscriberResponse createModifySubscriberResponse() {
        return new ModifySubscriberResponse();
    }

    /**
     * Create an instance of {@link MTRDataArray }
     * 
     */
    public MTRDataArray createMTRDataArray() {
        return new MTRDataArray();
    }

    /**
     * Create an instance of {@link SourceInfo }
     * 
     */
    public SourceInfo createSourceInfo() {
        return new SourceInfo();
    }

    /**
     * Create an instance of {@link CreateSubscriber }
     * 
     */
    public CreateSubscriber createCreateSubscriber() {
        return new CreateSubscriber();
    }

    /**
     * Create an instance of {@link SubscriberCreate }
     * 
     */
    public SubscriberCreate createSubscriberCreate() {
        return new SubscriberCreate();
    }

    /**
     * Create an instance of {@link CreateSubscriberResponse }
     * 
     */
    public CreateSubscriberResponse createCreateSubscriberResponse() {
        return new CreateSubscriberResponse();
    }

    /**
     * Create an instance of {@link GetUserConfig }
     * 
     */
    public GetUserConfig createGetUserConfig() {
        return new GetUserConfig();
    }

    /**
     * Create an instance of {@link GetUserConfigResponse }
     * 
     */
    public GetUserConfigResponse createGetUserConfigResponse() {
        return new GetUserConfigResponse();
    }

    /**
     * Create an instance of {@link SetUserConfig }
     * 
     */
    public SetUserConfig createSetUserConfig() {
        return new SetUserConfig();
    }

    /**
     * Create an instance of {@link SetUserConfigResponse }
     * 
     */
    public SetUserConfigResponse createSetUserConfigResponse() {
        return new SetUserConfigResponse();
    }

    /**
     * Create an instance of {@link RechargeAccountBySubscriber }
     * 
     */
    public RechargeAccountBySubscriber createRechargeAccountBySubscriber() {
        return new RechargeAccountBySubscriber();
    }

    /**
     * Create an instance of {@link RechargeAccountBySubscriberResponse }
     * 
     */
    public RechargeAccountBySubscriberResponse createRechargeAccountBySubscriberResponse() {
        return new RechargeAccountBySubscriberResponse();
    }

    /**
     * Create an instance of {@link ArrayOfDeltaBalance }
     * 
     */
    public ArrayOfDeltaBalance createArrayOfDeltaBalance() {
        return new ArrayOfDeltaBalance();
    }

    /**
     * Create an instance of {@link RechargeAccount }
     * 
     */
    public RechargeAccount createRechargeAccount() {
        return new RechargeAccount();
    }

    /**
     * Create an instance of {@link RechargeAccountResponse }
     * 
     */
    public RechargeAccountResponse createRechargeAccountResponse() {
        return new RechargeAccountResponse();
    }

    /**
     * Create an instance of {@link NonVoucherRecharge }
     * 
     */
    public NonVoucherRecharge createNonVoucherRecharge() {
        return new NonVoucherRecharge();
    }

    /**
     * Create an instance of {@link NonVoucherRechargeResponse }
     * 
     */
    public NonVoucherRechargeResponse createNonVoucherRechargeResponse() {
        return new NonVoucherRechargeResponse();
    }

    /**
     * Create an instance of {@link CreditAccount }
     * 
     */
    public CreditAccount createCreditAccount() {
        return new CreditAccount();
    }

    /**
     * Create an instance of {@link ArrayOfBalanceCreditAccount }
     * 
     */
    public ArrayOfBalanceCreditAccount createArrayOfBalanceCreditAccount() {
        return new ArrayOfBalanceCreditAccount();
    }

    /**
     * Create an instance of {@link CreditAccountResponse }
     * 
     */
    public CreditAccountResponse createCreditAccountResponse() {
        return new CreditAccountResponse();
    }

    /**
     * Create an instance of {@link SendSMSNotification }
     * 
     */
    public SendSMSNotification createSendSMSNotification() {
        return new SendSMSNotification();
    }

    /**
     * Create an instance of {@link SendSMSNotificationResponse }
     * 
     */
    public SendSMSNotificationResponse createSendSMSNotificationResponse() {
        return new SendSMSNotificationResponse();
    }

    /**
     * Create an instance of {@link DeleteSubscriber }
     * 
     */
    public DeleteSubscriber createDeleteSubscriber() {
        return new DeleteSubscriber();
    }

    /**
     * Create an instance of {@link DeleteSubscriberResponse }
     * 
     */
    public DeleteSubscriberResponse createDeleteSubscriberResponse() {
        return new DeleteSubscriberResponse();
    }

    /**
     * Create an instance of {@link CancelReservation }
     * 
     */
    public CancelReservation createCancelReservation() {
        return new CancelReservation();
    }

    /**
     * Create an instance of {@link CancelReservationResponse }
     * 
     */
    public CancelReservationResponse createCancelReservationResponse() {
        return new CancelReservationResponse();
    }

    /**
     * Create an instance of {@link GetSubscriberIdentities }
     * 
     */
    public GetSubscriberIdentities createGetSubscriberIdentities() {
        return new GetSubscriberIdentities();
    }

    /**
     * Create an instance of {@link GetSubscriberIdentitiesResponse }
     * 
     */
    public GetSubscriberIdentitiesResponse createGetSubscriberIdentitiesResponse() {
        return new GetSubscriberIdentitiesResponse();
    }

    /**
     * Create an instance of {@link ArrayOfIdentity }
     * 
     */
    public ArrayOfIdentity createArrayOfIdentity() {
        return new ArrayOfIdentity();
    }

    /**
     * Create an instance of {@link RetrieveSubscriberLite }
     * 
     */
    public RetrieveSubscriberLite createRetrieveSubscriberLite() {
        return new RetrieveSubscriberLite();
    }

    /**
     * Create an instance of {@link RetrieveSubscriberLiteResponse }
     * 
     */
    public RetrieveSubscriberLiteResponse createRetrieveSubscriberLiteResponse() {
        return new RetrieveSubscriberLiteResponse();
    }

    /**
     * Create an instance of {@link SubscriberRetrieveLite }
     * 
     */
    public SubscriberRetrieveLite createSubscriberRetrieveLite() {
        return new SubscriberRetrieveLite();
    }

    /**
     * Create an instance of {@link RetrieveSubscriberWithIdentityNoHistory }
     * 
     */
    public RetrieveSubscriberWithIdentityNoHistory createRetrieveSubscriberWithIdentityNoHistory() {
        return new RetrieveSubscriberWithIdentityNoHistory();
    }

    /**
     * Create an instance of {@link RetrieveSubscriberWithIdentityNoHistoryResponse }
     * 
     */
    public RetrieveSubscriberWithIdentityNoHistoryResponse createRetrieveSubscriberWithIdentityNoHistoryResponse() {
        return new RetrieveSubscriberWithIdentityNoHistoryResponse();
    }

    /**
     * Create an instance of {@link SubscriberRetrieve }
     * 
     */
    public SubscriberRetrieve createSubscriberRetrieve() {
        return new SubscriberRetrieve();
    }

    /**
     * Create an instance of {@link RetrieveSubscriberWithIdentityWithHistoryForMultipleIdentities }
     * 
     */
    public RetrieveSubscriberWithIdentityWithHistoryForMultipleIdentities createRetrieveSubscriberWithIdentityWithHistoryForMultipleIdentities() {
        return new RetrieveSubscriberWithIdentityWithHistoryForMultipleIdentities();
    }

    /**
     * Create an instance of {@link RetrieveSubscriberWithIdentityWithHistoryForMultipleIdentitiesResponse }
     * 
     */
    public RetrieveSubscriberWithIdentityWithHistoryForMultipleIdentitiesResponse createRetrieveSubscriberWithIdentityWithHistoryForMultipleIdentitiesResponse() {
        return new RetrieveSubscriberWithIdentityWithHistoryForMultipleIdentitiesResponse();
    }

    /**
     * Create an instance of {@link RetrieveSubscriberFastWithIdentityWithHistoryForMultipleIdentities }
     * 
     */
    public RetrieveSubscriberFastWithIdentityWithHistoryForMultipleIdentities createRetrieveSubscriberFastWithIdentityWithHistoryForMultipleIdentities() {
        return new RetrieveSubscriberFastWithIdentityWithHistoryForMultipleIdentities();
    }

    /**
     * Create an instance of {@link RetrieveSubscriberFastWithIdentityWithHistoryForMultipleIdentitiesResponse }
     * 
     */
    public RetrieveSubscriberFastWithIdentityWithHistoryForMultipleIdentitiesResponse createRetrieveSubscriberFastWithIdentityWithHistoryForMultipleIdentitiesResponse() {
        return new RetrieveSubscriberFastWithIdentityWithHistoryForMultipleIdentitiesResponse();
    }

    /**
     * Create an instance of {@link ChangeSubscriberID }
     * 
     */
    public ChangeSubscriberID createChangeSubscriberID() {
        return new ChangeSubscriberID();
    }

    /**
     * Create an instance of {@link ChangeSubscriberIDResponse }
     * 
     */
    public ChangeSubscriberIDResponse createChangeSubscriberIDResponse() {
        return new ChangeSubscriberIDResponse();
    }

    /**
     * Create an instance of {@link GetChargeCodes }
     * 
     */
    public GetChargeCodes createGetChargeCodes() {
        return new GetChargeCodes();
    }

    /**
     * Create an instance of {@link GetChargeCodesResponse }
     * 
     */
    public GetChargeCodesResponse createGetChargeCodesResponse() {
        return new GetChargeCodesResponse();
    }

    /**
     * Create an instance of {@link GetGlobalIdentities }
     * 
     */
    public GetGlobalIdentities createGetGlobalIdentities() {
        return new GetGlobalIdentities();
    }

    /**
     * Create an instance of {@link GetGlobalIdentitiesResponse }
     * 
     */
    public GetGlobalIdentitiesResponse createGetGlobalIdentitiesResponse() {
        return new GetGlobalIdentitiesResponse();
    }

    /**
     * Create an instance of {@link GetServiceParameters }
     * 
     */
    public GetServiceParameters createGetServiceParameters() {
        return new GetServiceParameters();
    }

    /**
     * Create an instance of {@link GetServiceParametersResponse }
     * 
     */
    public GetServiceParametersResponse createGetServiceParametersResponse() {
        return new GetServiceParametersResponse();
    }

    /**
     * Create an instance of {@link ArrayOfServiceParameter }
     * 
     */
    public ArrayOfServiceParameter createArrayOfServiceParameter() {
        return new ArrayOfServiceParameter();
    }

    /**
     * Create an instance of {@link GetRangeMap }
     * 
     */
    public GetRangeMap createGetRangeMap() {
        return new GetRangeMap();
    }

    /**
     * Create an instance of {@link GetRangeMapResponse }
     * 
     */
    public GetRangeMapResponse createGetRangeMapResponse() {
        return new GetRangeMapResponse();
    }

    /**
     * Create an instance of {@link ArrayOfRange }
     * 
     */
    public ArrayOfRange createArrayOfRange() {
        return new ArrayOfRange();
    }

    /**
     * Create an instance of {@link PostpaidCreditLimitReset }
     * 
     */
    public PostpaidCreditLimitReset createPostpaidCreditLimitReset() {
        return new PostpaidCreditLimitReset();
    }

    /**
     * Create an instance of {@link PostpaidCreditLimitResetResponse }
     * 
     */
    public PostpaidCreditLimitResetResponse createPostpaidCreditLimitResetResponse() {
        return new PostpaidCreditLimitResetResponse();
    }

    /**
     * Create an instance of {@link CatalogSync }
     * 
     */
    public CatalogSync createCatalogSync() {
        return new CatalogSync();
    }

    /**
     * Create an instance of {@link CatalogSyncResponse }
     * 
     */
    public CatalogSyncResponse createCatalogSyncResponse() {
        return new CatalogSyncResponse();
    }

    /**
     * Create an instance of {@link ChangeSubStatusAllIdentities }
     * 
     */
    public ChangeSubStatusAllIdentities createChangeSubStatusAllIdentities() {
        return new ChangeSubStatusAllIdentities();
    }

    /**
     * Create an instance of {@link ArrayOfIdentityStatus }
     * 
     */
    public ArrayOfIdentityStatus createArrayOfIdentityStatus() {
        return new ArrayOfIdentityStatus();
    }

    /**
     * Create an instance of {@link ChangeSubStatusAllIdentitiesResponse }
     * 
     */
    public ChangeSubStatusAllIdentitiesResponse createChangeSubStatusAllIdentitiesResponse() {
        return new ChangeSubStatusAllIdentitiesResponse();
    }

    /**
     * Create an instance of {@link CreateGroupAccount }
     * 
     */
    public CreateGroupAccount createCreateGroupAccount() {
        return new CreateGroupAccount();
    }

    /**
     * Create an instance of {@link GroupAccountCreate }
     * 
     */
    public GroupAccountCreate createGroupAccountCreate() {
        return new GroupAccountCreate();
    }

    /**
     * Create an instance of {@link CreateGroupAccountResponse }
     * 
     */
    public CreateGroupAccountResponse createCreateGroupAccountResponse() {
        return new CreateGroupAccountResponse();
    }

    /**
     * Create an instance of {@link ModifyGroupAccount }
     * 
     */
    public ModifyGroupAccount createModifyGroupAccount() {
        return new ModifyGroupAccount();
    }

    /**
     * Create an instance of {@link GroupAccountModify }
     * 
     */
    public GroupAccountModify createGroupAccountModify() {
        return new GroupAccountModify();
    }

    /**
     * Create an instance of {@link ModifyGroupAccountResponse }
     * 
     */
    public ModifyGroupAccountResponse createModifyGroupAccountResponse() {
        return new ModifyGroupAccountResponse();
    }

    /**
     * Create an instance of {@link DeleteGroupAccount }
     * 
     */
    public DeleteGroupAccount createDeleteGroupAccount() {
        return new DeleteGroupAccount();
    }

    /**
     * Create an instance of {@link DeleteGroupAccountResponse }
     * 
     */
    public DeleteGroupAccountResponse createDeleteGroupAccountResponse() {
        return new DeleteGroupAccountResponse();
    }

    /**
     * Create an instance of {@link GetGroupAccount }
     * 
     */
    public GetGroupAccount createGetGroupAccount() {
        return new GetGroupAccount();
    }

    /**
     * Create an instance of {@link GetGroupAccountResponse }
     * 
     */
    public GetGroupAccountResponse createGetGroupAccountResponse() {
        return new GetGroupAccountResponse();
    }

    /**
     * Create an instance of {@link GroupAccountRetrieve }
     * 
     */
    public GroupAccountRetrieve createGroupAccountRetrieve() {
        return new GroupAccountRetrieve();
    }

    /**
     * Create an instance of {@link GetGroupCount }
     * 
     */
    public GetGroupCount createGetGroupCount() {
        return new GetGroupCount();
    }

    /**
     * Create an instance of {@link GetGroupCountResponse }
     * 
     */
    public GetGroupCountResponse createGetGroupCountResponse() {
        return new GetGroupCountResponse();
    }

    /**
     * Create an instance of {@link RechargeAccountByGroupName }
     * 
     */
    public RechargeAccountByGroupName createRechargeAccountByGroupName() {
        return new RechargeAccountByGroupName();
    }

    /**
     * Create an instance of {@link RechargeAccountByGroupNameResponse }
     * 
     */
    public RechargeAccountByGroupNameResponse createRechargeAccountByGroupNameResponse() {
        return new RechargeAccountByGroupNameResponse();
    }

    /**
     * Create an instance of {@link GetGroupOwner }
     * 
     */
    public GetGroupOwner createGetGroupOwner() {
        return new GetGroupOwner();
    }

    /**
     * Create an instance of {@link GetGroupOwnerResponse }
     * 
     */
    public GetGroupOwnerResponse createGetGroupOwnerResponse() {
        return new GetGroupOwnerResponse();
    }

    /**
     * Create an instance of {@link SubscriberBasic }
     * 
     */
    public SubscriberBasic createSubscriberBasic() {
        return new SubscriberBasic();
    }

    /**
     * Create an instance of {@link AddMemberToGroup }
     * 
     */
    public AddMemberToGroup createAddMemberToGroup() {
        return new AddMemberToGroup();
    }

    /**
     * Create an instance of {@link AddMemberToGroupResponse }
     * 
     */
    public AddMemberToGroupResponse createAddMemberToGroupResponse() {
        return new AddMemberToGroupResponse();
    }

    /**
     * Create an instance of {@link RemoveMemberFromGroup }
     * 
     */
    public RemoveMemberFromGroup createRemoveMemberFromGroup() {
        return new RemoveMemberFromGroup();
    }

    /**
     * Create an instance of {@link RemoveMemberFromGroupResponse }
     * 
     */
    public RemoveMemberFromGroupResponse createRemoveMemberFromGroupResponse() {
        return new RemoveMemberFromGroupResponse();
    }

    /**
     * Create an instance of {@link GetAllGroupMembers }
     * 
     */
    public GetAllGroupMembers createGetAllGroupMembers() {
        return new GetAllGroupMembers();
    }

    /**
     * Create an instance of {@link GetAllGroupMembersResponse }
     * 
     */
    public GetAllGroupMembersResponse createGetAllGroupMembersResponse() {
        return new GetAllGroupMembersResponse();
    }

    /**
     * Create an instance of {@link ArrayOfSubscriberRetrieve }
     * 
     */
    public ArrayOfSubscriberRetrieve createArrayOfSubscriberRetrieve() {
        return new ArrayOfSubscriberRetrieve();
    }

    /**
     * Create an instance of {@link RetrievePostpaidBilledBalance }
     * 
     */
    public RetrievePostpaidBilledBalance createRetrievePostpaidBilledBalance() {
        return new RetrievePostpaidBilledBalance();
    }

    /**
     * Create an instance of {@link RetrievePostpaidBilledBalanceResponse }
     * 
     */
    public RetrievePostpaidBilledBalanceResponse createRetrievePostpaidBilledBalanceResponse() {
        return new RetrievePostpaidBilledBalanceResponse();
    }

    /**
     * Create an instance of {@link BilledBalance }
     * 
     */
    public BilledBalance createBilledBalance() {
        return new BilledBalance();
    }

    /**
     * Create an instance of {@link RechargeBilledAccount }
     * 
     */
    public RechargeBilledAccount createRechargeBilledAccount() {
        return new RechargeBilledAccount();
    }

    /**
     * Create an instance of {@link RechargeBilledAccountResponse }
     * 
     */
    public RechargeBilledAccountResponse createRechargeBilledAccountResponse() {
        return new RechargeBilledAccountResponse();
    }

    /**
     * Create an instance of {@link PostpaidDeltaBalance }
     * 
     */
    public PostpaidDeltaBalance createPostpaidDeltaBalance() {
        return new PostpaidDeltaBalance();
    }

    /**
     * Create an instance of {@link GetAccessNumbers }
     * 
     */
    public GetAccessNumbers createGetAccessNumbers() {
        return new GetAccessNumbers();
    }

    /**
     * Create an instance of {@link GetAccessNumbersResponse }
     * 
     */
    public GetAccessNumbersResponse createGetAccessNumbersResponse() {
        return new GetAccessNumbersResponse();
    }

    /**
     * Create an instance of {@link ArrayOfAccessNumberInfo }
     * 
     */
    public ArrayOfAccessNumberInfo createArrayOfAccessNumberInfo() {
        return new ArrayOfAccessNumberInfo();
    }

    /**
     * Create an instance of {@link UpdateNP }
     * 
     */
    public UpdateNP createUpdateNP() {
        return new UpdateNP();
    }

    /**
     * Create an instance of {@link UpdateNPResponse }
     * 
     */
    public UpdateNPResponse createUpdateNPResponse() {
        return new UpdateNPResponse();
    }

    /**
     * Create an instance of {@link RetrieveNP }
     * 
     */
    public RetrieveNP createRetrieveNP() {
        return new RetrieveNP();
    }

    /**
     * Create an instance of {@link RetrieveNPResponse }
     * 
     */
    public RetrieveNPResponse createRetrieveNPResponse() {
        return new RetrieveNPResponse();
    }

    /**
     * Create an instance of {@link NPEntity }
     * 
     */
    public NPEntity createNPEntity() {
        return new NPEntity();
    }

    /**
     * Create an instance of {@link DeleteNP }
     * 
     */
    public DeleteNP createDeleteNP() {
        return new DeleteNP();
    }

    /**
     * Create an instance of {@link DeleteNPResponse }
     * 
     */
    public DeleteNPResponse createDeleteNPResponse() {
        return new DeleteNPResponse();
    }

    /**
     * Create an instance of {@link ReserveVoucher }
     * 
     */
    public ReserveVoucher createReserveVoucher() {
        return new ReserveVoucher();
    }

    /**
     * Create an instance of {@link ReserveVoucherResponse }
     * 
     */
    public ReserveVoucherResponse createReserveVoucherResponse() {
        return new ReserveVoucherResponse();
    }

    /**
     * Create an instance of {@link UnReserveVoucher }
     * 
     */
    public UnReserveVoucher createUnReserveVoucher() {
        return new UnReserveVoucher();
    }

    /**
     * Create an instance of {@link UnReserveVoucherResponse }
     * 
     */
    public UnReserveVoucherResponse createUnReserveVoucherResponse() {
        return new UnReserveVoucherResponse();
    }

    /**
     * Create an instance of {@link ConsumeVoucher }
     * 
     */
    public ConsumeVoucher createConsumeVoucher() {
        return new ConsumeVoucher();
    }

    /**
     * Create an instance of {@link ConsumeVoucherResponse }
     * 
     */
    public ConsumeVoucherResponse createConsumeVoucherResponse() {
        return new ConsumeVoucherResponse();
    }

    /**
     * Create an instance of {@link ExternalNonVoucherRecharge }
     * 
     */
    public ExternalNonVoucherRecharge createExternalNonVoucherRecharge() {
        return new ExternalNonVoucherRecharge();
    }

    /**
     * Create an instance of {@link ExternalNonVoucherRechargeResponse }
     * 
     */
    public ExternalNonVoucherRechargeResponse createExternalNonVoucherRechargeResponse() {
        return new ExternalNonVoucherRechargeResponse();
    }

    /**
     * Create an instance of {@link AddCurrencyConversion }
     * 
     */
    public AddCurrencyConversion createAddCurrencyConversion() {
        return new AddCurrencyConversion();
    }

    /**
     * Create an instance of {@link CurrencyConversionCreate }
     * 
     */
    public CurrencyConversionCreate createCurrencyConversionCreate() {
        return new CurrencyConversionCreate();
    }

    /**
     * Create an instance of {@link AddCurrencyConversionResponse }
     * 
     */
    public AddCurrencyConversionResponse createAddCurrencyConversionResponse() {
        return new AddCurrencyConversionResponse();
    }

    /**
     * Create an instance of {@link ModifyCurrencyConversion }
     * 
     */
    public ModifyCurrencyConversion createModifyCurrencyConversion() {
        return new ModifyCurrencyConversion();
    }

    /**
     * Create an instance of {@link CurrencyConversionModify }
     * 
     */
    public CurrencyConversionModify createCurrencyConversionModify() {
        return new CurrencyConversionModify();
    }

    /**
     * Create an instance of {@link ModifyCurrencyConversionResponse }
     * 
     */
    public ModifyCurrencyConversionResponse createModifyCurrencyConversionResponse() {
        return new ModifyCurrencyConversionResponse();
    }

    /**
     * Create an instance of {@link RetrieveCurrencyConversion }
     * 
     */
    public RetrieveCurrencyConversion createRetrieveCurrencyConversion() {
        return new RetrieveCurrencyConversion();
    }

    /**
     * Create an instance of {@link CurrencyConversionDelete }
     * 
     */
    public CurrencyConversionDelete createCurrencyConversionDelete() {
        return new CurrencyConversionDelete();
    }

    /**
     * Create an instance of {@link RetrieveCurrencyConversionResponse }
     * 
     */
    public RetrieveCurrencyConversionResponse createRetrieveCurrencyConversionResponse() {
        return new RetrieveCurrencyConversionResponse();
    }

    /**
     * Create an instance of {@link ArrayOfCurrencyConversionRetrieve }
     * 
     */
    public ArrayOfCurrencyConversionRetrieve createArrayOfCurrencyConversionRetrieve() {
        return new ArrayOfCurrencyConversionRetrieve();
    }

    /**
     * Create an instance of {@link DeleteCurrencyConversion }
     * 
     */
    public DeleteCurrencyConversion createDeleteCurrencyConversion() {
        return new DeleteCurrencyConversion();
    }

    /**
     * Create an instance of {@link DeleteCurrencyConversionResponse }
     * 
     */
    public DeleteCurrencyConversionResponse createDeleteCurrencyConversionResponse() {
        return new DeleteCurrencyConversionResponse();
    }

    /**
     * Create an instance of {@link CreditAccumulator }
     * 
     */
    public CreditAccumulator createCreditAccumulator() {
        return new CreditAccumulator();
    }

    /**
     * Create an instance of {@link ArrayOfCreditAccumulator }
     * 
     */
    public ArrayOfCreditAccumulator createArrayOfCreditAccumulator() {
        return new ArrayOfCreditAccumulator();
    }

    /**
     * Create an instance of {@link CreditAccumulatorResponse }
     * 
     */
    public CreditAccumulatorResponse createCreditAccumulatorResponse() {
        return new CreditAccumulatorResponse();
    }

    /**
     * Create an instance of {@link NonVoucherRechargeGeneric }
     * 
     */
    public NonVoucherRechargeGeneric createNonVoucherRechargeGeneric() {
        return new NonVoucherRechargeGeneric();
    }

    /**
     * Create an instance of {@link NonVoucherRechargeRequest }
     * 
     */
    public NonVoucherRechargeRequest createNonVoucherRechargeRequest() {
        return new NonVoucherRechargeRequest();
    }

    /**
     * Create an instance of {@link NonVoucherRechargeGenericResponse }
     * 
     */
    public NonVoucherRechargeGenericResponse createNonVoucherRechargeGenericResponse() {
        return new NonVoucherRechargeGenericResponse();
    }

    /**
     * Create an instance of {@link NonVoucherRechargeResponse2 }
     * 
     */
    public NonVoucherRechargeResponse2 createNonVoucherRechargeResponse2() {
        return new NonVoucherRechargeResponse2();
    }

    /**
     * Create an instance of {@link ChangeCOS }
     * 
     */
    public ChangeCOS createChangeCOS() {
        return new ChangeCOS();
    }

    /**
     * Create an instance of {@link ChangeCOSRequest }
     * 
     */
    public ChangeCOSRequest createChangeCOSRequest() {
        return new ChangeCOSRequest();
    }

    /**
     * Create an instance of {@link ChangeCOSResponse }
     * 
     */
    public ChangeCOSResponse createChangeCOSResponse() {
        return new ChangeCOSResponse();
    }

    /**
     * Create an instance of {@link ChangeCOSResponse2 }
     * 
     */
    public ChangeCOSResponse2 createChangeCOSResponse2() {
        return new ChangeCOSResponse2();
    }

    /**
     * Create an instance of {@link CreateHomeLocation }
     * 
     */
    public CreateHomeLocation createCreateHomeLocation() {
        return new CreateHomeLocation();
    }

    /**
     * Create an instance of {@link CreateHomeLocationRequest }
     * 
     */
    public CreateHomeLocationRequest createCreateHomeLocationRequest() {
        return new CreateHomeLocationRequest();
    }

    /**
     * Create an instance of {@link CreateHomeLocationResponse }
     * 
     */
    public CreateHomeLocationResponse createCreateHomeLocationResponse() {
        return new CreateHomeLocationResponse();
    }

    /**
     * Create an instance of {@link HomeLocationResponse }
     * 
     */
    public HomeLocationResponse createHomeLocationResponse() {
        return new HomeLocationResponse();
    }

    /**
     * Create an instance of {@link DeleteHomeLocation }
     * 
     */
    public DeleteHomeLocation createDeleteHomeLocation() {
        return new DeleteHomeLocation();
    }

    /**
     * Create an instance of {@link DeleteHomeLocationRequest }
     * 
     */
    public DeleteHomeLocationRequest createDeleteHomeLocationRequest() {
        return new DeleteHomeLocationRequest();
    }

    /**
     * Create an instance of {@link DeleteHomeLocationResponse }
     * 
     */
    public DeleteHomeLocationResponse createDeleteHomeLocationResponse() {
        return new DeleteHomeLocationResponse();
    }

    /**
     * Create an instance of {@link CreatePhonebookNumber }
     * 
     */
    public CreatePhonebookNumber createCreatePhonebookNumber() {
        return new CreatePhonebookNumber();
    }

    /**
     * Create an instance of {@link CreatePhonebookNumberRequest }
     * 
     */
    public CreatePhonebookNumberRequest createCreatePhonebookNumberRequest() {
        return new CreatePhonebookNumberRequest();
    }

    /**
     * Create an instance of {@link CreatePhonebookNumberResponse }
     * 
     */
    public CreatePhonebookNumberResponse createCreatePhonebookNumberResponse() {
        return new CreatePhonebookNumberResponse();
    }

    /**
     * Create an instance of {@link PhonebookNumberResponse }
     * 
     */
    public PhonebookNumberResponse createPhonebookNumberResponse() {
        return new PhonebookNumberResponse();
    }

    /**
     * Create an instance of {@link DeletePhonebookNumber }
     * 
     */
    public DeletePhonebookNumber createDeletePhonebookNumber() {
        return new DeletePhonebookNumber();
    }

    /**
     * Create an instance of {@link DeletePhonebookNumberRequest }
     * 
     */
    public DeletePhonebookNumberRequest createDeletePhonebookNumberRequest() {
        return new DeletePhonebookNumberRequest();
    }

    /**
     * Create an instance of {@link DeletePhonebookNumberResponse }
     * 
     */
    public DeletePhonebookNumberResponse createDeletePhonebookNumberResponse() {
        return new DeletePhonebookNumberResponse();
    }

    /**
     * Create an instance of {@link CreatePeriodicCharge }
     * 
     */
    public CreatePeriodicCharge createCreatePeriodicCharge() {
        return new CreatePeriodicCharge();
    }

    /**
     * Create an instance of {@link CreatePeriodicChargeRequest }
     * 
     */
    public CreatePeriodicChargeRequest createCreatePeriodicChargeRequest() {
        return new CreatePeriodicChargeRequest();
    }

    /**
     * Create an instance of {@link CreatePeriodicChargeResponse }
     * 
     */
    public CreatePeriodicChargeResponse createCreatePeriodicChargeResponse() {
        return new CreatePeriodicChargeResponse();
    }

    /**
     * Create an instance of {@link PeriodicChargeResponse }
     * 
     */
    public PeriodicChargeResponse createPeriodicChargeResponse() {
        return new PeriodicChargeResponse();
    }

    /**
     * Create an instance of {@link DeletePeriodicCharge }
     * 
     */
    public DeletePeriodicCharge createDeletePeriodicCharge() {
        return new DeletePeriodicCharge();
    }

    /**
     * Create an instance of {@link DeletePeriodicChargeRequest }
     * 
     */
    public DeletePeriodicChargeRequest createDeletePeriodicChargeRequest() {
        return new DeletePeriodicChargeRequest();
    }

    /**
     * Create an instance of {@link DeletePeriodicChargeResponse }
     * 
     */
    public DeletePeriodicChargeResponse createDeletePeriodicChargeResponse() {
        return new DeletePeriodicChargeResponse();
    }

    /**
     * Create an instance of {@link ChangeCallingCircle }
     * 
     */
    public ChangeCallingCircle createChangeCallingCircle() {
        return new ChangeCallingCircle();
    }

    /**
     * Create an instance of {@link ChangeCallingCircleRequest }
     * 
     */
    public ChangeCallingCircleRequest createChangeCallingCircleRequest() {
        return new ChangeCallingCircleRequest();
    }

    /**
     * Create an instance of {@link ChangeCallingCircleResponse }
     * 
     */
    public ChangeCallingCircleResponse createChangeCallingCircleResponse() {
        return new ChangeCallingCircleResponse();
    }

    /**
     * Create an instance of {@link ChangeCallingCircleResponse2 }
     * 
     */
    public ChangeCallingCircleResponse2 createChangeCallingCircleResponse2() {
        return new ChangeCallingCircleResponse2();
    }

    /**
     * Create an instance of {@link DeleteCallingCircle }
     * 
     */
    public DeleteCallingCircle createDeleteCallingCircle() {
        return new DeleteCallingCircle();
    }

    /**
     * Create an instance of {@link DeleteCallingCircleRequest }
     * 
     */
    public DeleteCallingCircleRequest createDeleteCallingCircleRequest() {
        return new DeleteCallingCircleRequest();
    }

    /**
     * Create an instance of {@link DeleteCallingCircleResponse }
     * 
     */
    public DeleteCallingCircleResponse createDeleteCallingCircleResponse() {
        return new DeleteCallingCircleResponse();
    }

    /**
     * Create an instance of {@link DeleteCallingCircleResponse2 }
     * 
     */
    public DeleteCallingCircleResponse2 createDeleteCallingCircleResponse2() {
        return new DeleteCallingCircleResponse2();
    }

    /**
     * Create an instance of {@link RetrieveCallingCircles }
     * 
     */
    public RetrieveCallingCircles createRetrieveCallingCircles() {
        return new RetrieveCallingCircles();
    }

    /**
     * Create an instance of {@link RetrieveCallingCirclesRequest }
     * 
     */
    public RetrieveCallingCirclesRequest createRetrieveCallingCirclesRequest() {
        return new RetrieveCallingCirclesRequest();
    }

    /**
     * Create an instance of {@link RetrieveCallingCirclesResponse }
     * 
     */
    public RetrieveCallingCirclesResponse createRetrieveCallingCirclesResponse() {
        return new RetrieveCallingCirclesResponse();
    }

    /**
     * Create an instance of {@link RetrieveCallingCirclesResponse2 }
     * 
     */
    public RetrieveCallingCirclesResponse2 createRetrieveCallingCirclesResponse2() {
        return new RetrieveCallingCirclesResponse2();
    }

    /**
     * Create an instance of {@link ModifyCallingCircleMembers }
     * 
     */
    public ModifyCallingCircleMembers createModifyCallingCircleMembers() {
        return new ModifyCallingCircleMembers();
    }

    /**
     * Create an instance of {@link ArrayOfCircleMemberOperation }
     * 
     */
    public ArrayOfCircleMemberOperation createArrayOfCircleMemberOperation() {
        return new ArrayOfCircleMemberOperation();
    }

    /**
     * Create an instance of {@link ModifyCallingCircleMembersResponse }
     * 
     */
    public ModifyCallingCircleMembersResponse createModifyCallingCircleMembersResponse() {
        return new ModifyCallingCircleMembersResponse();
    }

    /**
     * Create an instance of {@link ArrayOfCircleOperationResponse }
     * 
     */
    public ArrayOfCircleOperationResponse createArrayOfCircleOperationResponse() {
        return new ArrayOfCircleOperationResponse();
    }

    /**
     * Create an instance of {@link RetrieveCircleMembers }
     * 
     */
    public RetrieveCircleMembers createRetrieveCircleMembers() {
        return new RetrieveCircleMembers();
    }

    /**
     * Create an instance of {@link RetrieveCircleMembersRequest }
     * 
     */
    public RetrieveCircleMembersRequest createRetrieveCircleMembersRequest() {
        return new RetrieveCircleMembersRequest();
    }

    /**
     * Create an instance of {@link RetrieveCircleMembersResponse }
     * 
     */
    public RetrieveCircleMembersResponse createRetrieveCircleMembersResponse() {
        return new RetrieveCircleMembersResponse();
    }

    /**
     * Create an instance of {@link RetrieveCirclesMembersResponse }
     * 
     */
    public RetrieveCirclesMembersResponse createRetrieveCirclesMembersResponse() {
        return new RetrieveCirclesMembersResponse();
    }

    /**
     * Create an instance of {@link SetAccumulatorValue }
     * 
     */
    public SetAccumulatorValue createSetAccumulatorValue() {
        return new SetAccumulatorValue();
    }

    /**
     * Create an instance of {@link SetAccumulatorValueRequest }
     * 
     */
    public SetAccumulatorValueRequest createSetAccumulatorValueRequest() {
        return new SetAccumulatorValueRequest();
    }

    /**
     * Create an instance of {@link SetAccumulatorValueResponse }
     * 
     */
    public SetAccumulatorValueResponse createSetAccumulatorValueResponse() {
        return new SetAccumulatorValueResponse();
    }

    /**
     * Create an instance of {@link SetAccumulatorValueResponse2 }
     * 
     */
    public SetAccumulatorValueResponse2 createSetAccumulatorValueResponse2() {
        return new SetAccumulatorValueResponse2();
    }

    /**
     * Create an instance of {@link RetrieveAccumulatorValue }
     * 
     */
    public RetrieveAccumulatorValue createRetrieveAccumulatorValue() {
        return new RetrieveAccumulatorValue();
    }

    /**
     * Create an instance of {@link RetrieveAccumulatorValueRequest }
     * 
     */
    public RetrieveAccumulatorValueRequest createRetrieveAccumulatorValueRequest() {
        return new RetrieveAccumulatorValueRequest();
    }

    /**
     * Create an instance of {@link RetrieveAccumulatorValueResponse }
     * 
     */
    public RetrieveAccumulatorValueResponse createRetrieveAccumulatorValueResponse() {
        return new RetrieveAccumulatorValueResponse();
    }

    /**
     * Create an instance of {@link RetrieveAccumulatorValueResponse2 }
     * 
     */
    public RetrieveAccumulatorValueResponse2 createRetrieveAccumulatorValueResponse2() {
        return new RetrieveAccumulatorValueResponse2();
    }

    /**
     * Create an instance of {@link AssignBonusPlan }
     * 
     */
    public AssignBonusPlan createAssignBonusPlan() {
        return new AssignBonusPlan();
    }

    /**
     * Create an instance of {@link AssignBonusPlanRequest }
     * 
     */
    public AssignBonusPlanRequest createAssignBonusPlanRequest() {
        return new AssignBonusPlanRequest();
    }

    /**
     * Create an instance of {@link AssignBonusPlanResponse }
     * 
     */
    public AssignBonusPlanResponse createAssignBonusPlanResponse() {
        return new AssignBonusPlanResponse();
    }

    /**
     * Create an instance of {@link AssignBonusPlanResponse2 }
     * 
     */
    public AssignBonusPlanResponse2 createAssignBonusPlanResponse2() {
        return new AssignBonusPlanResponse2();
    }

    /**
     * Create an instance of {@link RemoveBonusPlan }
     * 
     */
    public RemoveBonusPlan createRemoveBonusPlan() {
        return new RemoveBonusPlan();
    }

    /**
     * Create an instance of {@link RemoveBonusPlanRequest }
     * 
     */
    public RemoveBonusPlanRequest createRemoveBonusPlanRequest() {
        return new RemoveBonusPlanRequest();
    }

    /**
     * Create an instance of {@link RemoveBonusPlanResponse }
     * 
     */
    public RemoveBonusPlanResponse createRemoveBonusPlanResponse() {
        return new RemoveBonusPlanResponse();
    }

    /**
     * Create an instance of {@link RemoveBonusPlanResponse2 }
     * 
     */
    public RemoveBonusPlanResponse2 createRemoveBonusPlanResponse2() {
        return new RemoveBonusPlanResponse2();
    }

    /**
     * Create an instance of {@link GetSubscriberDataForAllIdentities }
     * 
     */
    public GetSubscriberDataForAllIdentities createGetSubscriberDataForAllIdentities() {
        return new GetSubscriberDataForAllIdentities();
    }

    /**
     * Create an instance of {@link GetSubscriberDataForAllIdentityRequest }
     * 
     */
    public GetSubscriberDataForAllIdentityRequest createGetSubscriberDataForAllIdentityRequest() {
        return new GetSubscriberDataForAllIdentityRequest();
    }

    /**
     * Create an instance of {@link GetSubscriberDataForAllIdentitiesResponse }
     * 
     */
    public GetSubscriberDataForAllIdentitiesResponse createGetSubscriberDataForAllIdentitiesResponse() {
        return new GetSubscriberDataForAllIdentitiesResponse();
    }

    /**
     * Create an instance of {@link GetSubscriberDataForAllIdentityResponse }
     * 
     */
    public GetSubscriberDataForAllIdentityResponse createGetSubscriberDataForAllIdentityResponse() {
        return new GetSubscriberDataForAllIdentityResponse();
    }

    /**
     * Create an instance of {@link UpdateSubscriberDataForAllIdentities }
     * 
     */
    public UpdateSubscriberDataForAllIdentities createUpdateSubscriberDataForAllIdentities() {
        return new UpdateSubscriberDataForAllIdentities();
    }

    /**
     * Create an instance of {@link UpdateSubscriberDataForAllIdentityRequest }
     * 
     */
    public UpdateSubscriberDataForAllIdentityRequest createUpdateSubscriberDataForAllIdentityRequest() {
        return new UpdateSubscriberDataForAllIdentityRequest();
    }

    /**
     * Create an instance of {@link UpdateSubscriberDataForAllIdentitiesResponse }
     * 
     */
    public UpdateSubscriberDataForAllIdentitiesResponse createUpdateSubscriberDataForAllIdentitiesResponse() {
        return new UpdateSubscriberDataForAllIdentitiesResponse();
    }

    /**
     * Create an instance of {@link UpdateSubscriberDataForAllIdentityResponse }
     * 
     */
    public UpdateSubscriberDataForAllIdentityResponse createUpdateSubscriberDataForAllIdentityResponse() {
        return new UpdateSubscriberDataForAllIdentityResponse();
    }

    /**
     * Create an instance of {@link AuditEvent }
     * 
     */
    public AuditEvent createAuditEvent() {
        return new AuditEvent();
    }

    /**
     * Create an instance of {@link AuditEventResponse }
     * 
     */
    public AuditEventResponse createAuditEventResponse() {
        return new AuditEventResponse();
    }

    /**
     * Create an instance of {@link PromisedPayment }
     * 
     */
    public PromisedPayment createPromisedPayment() {
        return new PromisedPayment();
    }

    /**
     * Create an instance of {@link PromisedPaymentRequest }
     * 
     */
    public PromisedPaymentRequest createPromisedPaymentRequest() {
        return new PromisedPaymentRequest();
    }

    /**
     * Create an instance of {@link PromisedPaymentResponse }
     * 
     */
    public PromisedPaymentResponse createPromisedPaymentResponse() {
        return new PromisedPaymentResponse();
    }

    /**
     * Create an instance of {@link PromisedPaymentResponse2 }
     * 
     */
    public PromisedPaymentResponse2 createPromisedPaymentResponse2() {
        return new PromisedPaymentResponse2();
    }

    /**
     * Create an instance of {@link RechargeAccountWithPI }
     * 
     */
    public RechargeAccountWithPI createRechargeAccountWithPI() {
        return new RechargeAccountWithPI();
    }

    /**
     * Create an instance of {@link RechargeAccountPIRequest }
     * 
     */
    public RechargeAccountPIRequest createRechargeAccountPIRequest() {
        return new RechargeAccountPIRequest();
    }

    /**
     * Create an instance of {@link RechargeAccountWithPIResponse }
     * 
     */
    public RechargeAccountWithPIResponse createRechargeAccountWithPIResponse() {
        return new RechargeAccountWithPIResponse();
    }

    /**
     * Create an instance of {@link RechargeAccountPIResponse }
     * 
     */
    public RechargeAccountPIResponse createRechargeAccountPIResponse() {
        return new RechargeAccountPIResponse();
    }

    /**
     * Create an instance of {@link SubscribeOffer }
     * 
     */
    public SubscribeOffer createSubscribeOffer() {
        return new SubscribeOffer();
    }

    /**
     * Create an instance of {@link OfferSubscribeRequest }
     * 
     */
    public OfferSubscribeRequest createOfferSubscribeRequest() {
        return new OfferSubscribeRequest();
    }

    /**
     * Create an instance of {@link SubscribeOfferResponse }
     * 
     */
    public SubscribeOfferResponse createSubscribeOfferResponse() {
        return new SubscribeOfferResponse();
    }

    /**
     * Create an instance of {@link UnsubscribeOffer }
     * 
     */
    public UnsubscribeOffer createUnsubscribeOffer() {
        return new UnsubscribeOffer();
    }

    /**
     * Create an instance of {@link OfferUnsubscribeRequest }
     * 
     */
    public OfferUnsubscribeRequest createOfferUnsubscribeRequest() {
        return new OfferUnsubscribeRequest();
    }

    /**
     * Create an instance of {@link UnsubscribeOfferResponse }
     * 
     */
    public UnsubscribeOfferResponse createUnsubscribeOfferResponse() {
        return new UnsubscribeOfferResponse();
    }

    /**
     * Create an instance of {@link IVRChangeLanguage }
     * 
     */
    public IVRChangeLanguage createIVRChangeLanguage() {
        return new IVRChangeLanguage();
    }

    /**
     * Create an instance of {@link IVRChangeLanguageRequest }
     * 
     */
    public IVRChangeLanguageRequest createIVRChangeLanguageRequest() {
        return new IVRChangeLanguageRequest();
    }

    /**
     * Create an instance of {@link IVRChangeLanguageResponse }
     * 
     */
    public IVRChangeLanguageResponse createIVRChangeLanguageResponse() {
        return new IVRChangeLanguageResponse();
    }

    /**
     * Create an instance of {@link IVRChangeLanguageResponse2 }
     * 
     */
    public IVRChangeLanguageResponse2 createIVRChangeLanguageResponse2() {
        return new IVRChangeLanguageResponse2();
    }

    /**
     * Create an instance of {@link IVRGetGroupAccountWithOwner }
     * 
     */
    public IVRGetGroupAccountWithOwner createIVRGetGroupAccountWithOwner() {
        return new IVRGetGroupAccountWithOwner();
    }

    /**
     * Create an instance of {@link IVRGetGroupAccountWithOwnerRequest }
     * 
     */
    public IVRGetGroupAccountWithOwnerRequest createIVRGetGroupAccountWithOwnerRequest() {
        return new IVRGetGroupAccountWithOwnerRequest();
    }

    /**
     * Create an instance of {@link IVRGetGroupAccountWithOwnerResponse }
     * 
     */
    public IVRGetGroupAccountWithOwnerResponse createIVRGetGroupAccountWithOwnerResponse() {
        return new IVRGetGroupAccountWithOwnerResponse();
    }

    /**
     * Create an instance of {@link IVRGetGroupAccountWithOwnerResponse2 }
     * 
     */
    public IVRGetGroupAccountWithOwnerResponse2 createIVRGetGroupAccountWithOwnerResponse2() {
        return new IVRGetGroupAccountWithOwnerResponse2();
    }

    /**
     * Create an instance of {@link IVRRechargeBySubscriberWithSessionValue }
     * 
     */
    public IVRRechargeBySubscriberWithSessionValue createIVRRechargeBySubscriberWithSessionValue() {
        return new IVRRechargeBySubscriberWithSessionValue();
    }

    /**
     * Create an instance of {@link IVRDeltaBalanceWithSessionValueRequest }
     * 
     */
    public IVRDeltaBalanceWithSessionValueRequest createIVRDeltaBalanceWithSessionValueRequest() {
        return new IVRDeltaBalanceWithSessionValueRequest();
    }

    /**
     * Create an instance of {@link IVRRechargeBySubscriberWithSessionValueResponse }
     * 
     */
    public IVRRechargeBySubscriberWithSessionValueResponse createIVRRechargeBySubscriberWithSessionValueResponse() {
        return new IVRRechargeBySubscriberWithSessionValueResponse();
    }

    /**
     * Create an instance of {@link IVRDeltaBalanceWithSessionValueResponse }
     * 
     */
    public IVRDeltaBalanceWithSessionValueResponse createIVRDeltaBalanceWithSessionValueResponse() {
        return new IVRDeltaBalanceWithSessionValueResponse();
    }

    /**
     * Create an instance of {@link GetPasswordWarningDays }
     * 
     */
    public GetPasswordWarningDays createGetPasswordWarningDays() {
        return new GetPasswordWarningDays();
    }

    /**
     * Create an instance of {@link GetPasswordWarningDaysResponse }
     * 
     */
    public GetPasswordWarningDaysResponse createGetPasswordWarningDaysResponse() {
        return new GetPasswordWarningDaysResponse();
    }

    /**
     * Create an instance of {@link CreateSpecialHomeArea }
     * 
     */
    public CreateSpecialHomeArea createCreateSpecialHomeArea() {
        return new CreateSpecialHomeArea();
    }

    /**
     * Create an instance of {@link SpecialHomeAreaRequest }
     * 
     */
    public SpecialHomeAreaRequest createSpecialHomeAreaRequest() {
        return new SpecialHomeAreaRequest();
    }

    /**
     * Create an instance of {@link CreateSpecialHomeAreaResponse }
     * 
     */
    public CreateSpecialHomeAreaResponse createCreateSpecialHomeAreaResponse() {
        return new CreateSpecialHomeAreaResponse();
    }

    /**
     * Create an instance of {@link ModifySpecialHomeArea }
     * 
     */
    public ModifySpecialHomeArea createModifySpecialHomeArea() {
        return new ModifySpecialHomeArea();
    }

    /**
     * Create an instance of {@link ModifySpecialHomeAreaResponse }
     * 
     */
    public ModifySpecialHomeAreaResponse createModifySpecialHomeAreaResponse() {
        return new ModifySpecialHomeAreaResponse();
    }

    /**
     * Create an instance of {@link DeleteSpecialHomeArea }
     * 
     */
    public DeleteSpecialHomeArea createDeleteSpecialHomeArea() {
        return new DeleteSpecialHomeArea();
    }

    /**
     * Create an instance of {@link DeleteSpecialHomeAreaRequest }
     * 
     */
    public DeleteSpecialHomeAreaRequest createDeleteSpecialHomeAreaRequest() {
        return new DeleteSpecialHomeAreaRequest();
    }

    /**
     * Create an instance of {@link DeleteSpecialHomeAreaResponse }
     * 
     */
    public DeleteSpecialHomeAreaResponse createDeleteSpecialHomeAreaResponse() {
        return new DeleteSpecialHomeAreaResponse();
    }

    /**
     * Create an instance of {@link GetSpecialHomeAreas }
     * 
     */
    public GetSpecialHomeAreas createGetSpecialHomeAreas() {
        return new GetSpecialHomeAreas();
    }

    /**
     * Create an instance of {@link GetSpecialHomeAreasResponse }
     * 
     */
    public GetSpecialHomeAreasResponse createGetSpecialHomeAreasResponse() {
        return new GetSpecialHomeAreasResponse();
    }

    /**
     * Create an instance of {@link SetSubscriberHappyHour }
     * 
     */
    public SetSubscriberHappyHour createSetSubscriberHappyHour() {
        return new SetSubscriberHappyHour();
    }

    /**
     * Create an instance of {@link HappyHourRequest }
     * 
     */
    public HappyHourRequest createHappyHourRequest() {
        return new HappyHourRequest();
    }

    /**
     * Create an instance of {@link SetSubscriberHappyHourResponse }
     * 
     */
    public SetSubscriberHappyHourResponse createSetSubscriberHappyHourResponse() {
        return new SetSubscriberHappyHourResponse();
    }

    /**
     * Create an instance of {@link AddPreferredNumberToSubscriber }
     * 
     */
    public AddPreferredNumberToSubscriber createAddPreferredNumberToSubscriber() {
        return new AddPreferredNumberToSubscriber();
    }

    /**
     * Create an instance of {@link PreferredNumberAddRequest }
     * 
     */
    public PreferredNumberAddRequest createPreferredNumberAddRequest() {
        return new PreferredNumberAddRequest();
    }

    /**
     * Create an instance of {@link AddPreferredNumberToSubscriberResponse }
     * 
     */
    public AddPreferredNumberToSubscriberResponse createAddPreferredNumberToSubscriberResponse() {
        return new AddPreferredNumberToSubscriberResponse();
    }

    /**
     * Create an instance of {@link PreferredNumberResponse }
     * 
     */
    public PreferredNumberResponse createPreferredNumberResponse() {
        return new PreferredNumberResponse();
    }

    /**
     * Create an instance of {@link ModifyPreferredNumberToSubscriber }
     * 
     */
    public ModifyPreferredNumberToSubscriber createModifyPreferredNumberToSubscriber() {
        return new ModifyPreferredNumberToSubscriber();
    }

    /**
     * Create an instance of {@link PreferredNumberModifyRequest }
     * 
     */
    public PreferredNumberModifyRequest createPreferredNumberModifyRequest() {
        return new PreferredNumberModifyRequest();
    }

    /**
     * Create an instance of {@link ModifyPreferredNumberToSubscriberResponse }
     * 
     */
    public ModifyPreferredNumberToSubscriberResponse createModifyPreferredNumberToSubscriberResponse() {
        return new ModifyPreferredNumberToSubscriberResponse();
    }

    /**
     * Create an instance of {@link RemovePreferredNumberFromSubscriber }
     * 
     */
    public RemovePreferredNumberFromSubscriber createRemovePreferredNumberFromSubscriber() {
        return new RemovePreferredNumberFromSubscriber();
    }

    /**
     * Create an instance of {@link RemovePreferredNumberFromSubscriberResponse }
     * 
     */
    public RemovePreferredNumberFromSubscriberResponse createRemovePreferredNumberFromSubscriberResponse() {
        return new RemovePreferredNumberFromSubscriberResponse();
    }

    /**
     * Create an instance of {@link ForgiveSubscriberDebt }
     * 
     */
    public ForgiveSubscriberDebt createForgiveSubscriberDebt() {
        return new ForgiveSubscriberDebt();
    }

    /**
     * Create an instance of {@link ForgiveSubscriberDebtRequest }
     * 
     */
    public ForgiveSubscriberDebtRequest createForgiveSubscriberDebtRequest() {
        return new ForgiveSubscriberDebtRequest();
    }

    /**
     * Create an instance of {@link ForgiveSubscriberDebtResponse }
     * 
     */
    public ForgiveSubscriberDebtResponse createForgiveSubscriberDebtResponse() {
        return new ForgiveSubscriberDebtResponse();
    }

    /**
     * Create an instance of {@link ForgiveSubscriberDebtResponse2 }
     * 
     */
    public ForgiveSubscriberDebtResponse2 createForgiveSubscriberDebtResponse2() {
        return new ForgiveSubscriberDebtResponse2();
    }

    /**
     * Create an instance of {@link CachedTables }
     * 
     */
    public CachedTables createCachedTables() {
        return new CachedTables();
    }

    /**
     * Create an instance of {@link ArrayOfOverrideHomeAreas }
     * 
     */
    public ArrayOfOverrideHomeAreas createArrayOfOverrideHomeAreas() {
        return new ArrayOfOverrideHomeAreas();
    }

    /**
     * Create an instance of {@link OverrideHomeAreas }
     * 
     */
    public OverrideHomeAreas createOverrideHomeAreas() {
        return new OverrideHomeAreas();
    }

    /**
     * Create an instance of {@link ArrayOfOffer }
     * 
     */
    public ArrayOfOffer createArrayOfOffer() {
        return new ArrayOfOffer();
    }

    /**
     * Create an instance of {@link Offer }
     * 
     */
    public Offer createOffer() {
        return new Offer();
    }

    /**
     * Create an instance of {@link OfferBase }
     * 
     */
    public OfferBase createOfferBase() {
        return new OfferBase();
    }

    /**
     * Create an instance of {@link ArrayOfBalanceDefinition }
     * 
     */
    public ArrayOfBalanceDefinition createArrayOfBalanceDefinition() {
        return new ArrayOfBalanceDefinition();
    }

    /**
     * Create an instance of {@link BalanceDefinition }
     * 
     */
    public BalanceDefinition createBalanceDefinition() {
        return new BalanceDefinition();
    }

    /**
     * Create an instance of {@link ArrayOfAccumulator }
     * 
     */
    public ArrayOfAccumulator createArrayOfAccumulator() {
        return new ArrayOfAccumulator();
    }

    /**
     * Create an instance of {@link Accumulator }
     * 
     */
    public Accumulator createAccumulator() {
        return new Accumulator();
    }

    /**
     * Create an instance of {@link ArrayOfBonusPlan }
     * 
     */
    public ArrayOfBonusPlan createArrayOfBonusPlan() {
        return new ArrayOfBonusPlan();
    }

    /**
     * Create an instance of {@link BONUSPLANEXTENSIONDATA }
     * 
     */
    public BONUSPLANEXTENSIONDATA createBONUSPLANEXTENSIONDATA() {
        return new BONUSPLANEXTENSIONDATA();
    }

    /**
     * Create an instance of {@link ArrayOfDiscountPlan }
     * 
     */
    public ArrayOfDiscountPlan createArrayOfDiscountPlan() {
        return new ArrayOfDiscountPlan();
    }

    /**
     * Create an instance of {@link DISCOUNTPLANEXTENSIONDATA }
     * 
     */
    public DISCOUNTPLANEXTENSIONDATA createDISCOUNTPLANEXTENSIONDATA() {
        return new DISCOUNTPLANEXTENSIONDATA();
    }

    /**
     * Create an instance of {@link ArrayOfPeriodicCharge }
     * 
     */
    public ArrayOfPeriodicCharge createArrayOfPeriodicCharge() {
        return new ArrayOfPeriodicCharge();
    }

    /**
     * Create an instance of {@link PeriodicCharge }
     * 
     */
    public PeriodicCharge createPeriodicCharge() {
        return new PeriodicCharge();
    }

    /**
     * Create an instance of {@link ArrayOfChargeBalance }
     * 
     */
    public ArrayOfChargeBalance createArrayOfChargeBalance() {
        return new ArrayOfChargeBalance();
    }

    /**
     * Create an instance of {@link ChargeBalance }
     * 
     */
    public ChargeBalance createChargeBalance() {
        return new ChargeBalance();
    }

    /**
     * Create an instance of {@link ArrayOfActivityDefinition }
     * 
     */
    public ArrayOfActivityDefinition createArrayOfActivityDefinition() {
        return new ArrayOfActivityDefinition();
    }

    /**
     * Create an instance of {@link ActivityDefinition }
     * 
     */
    public ActivityDefinition createActivityDefinition() {
        return new ActivityDefinition();
    }

    /**
     * Create an instance of {@link ArrayOfUnitType }
     * 
     */
    public ArrayOfUnitType createArrayOfUnitType() {
        return new ArrayOfUnitType();
    }

    /**
     * Create an instance of {@link UnitType }
     * 
     */
    public UnitType createUnitType() {
        return new UnitType();
    }

    /**
     * Create an instance of {@link ArrayOfClassOfService }
     * 
     */
    public ArrayOfClassOfService createArrayOfClassOfService() {
        return new ArrayOfClassOfService();
    }

    /**
     * Create an instance of {@link ArrayOfCosAccumulator }
     * 
     */
    public ArrayOfCosAccumulator createArrayOfCosAccumulator() {
        return new ArrayOfCosAccumulator();
    }

    /**
     * Create an instance of {@link CosAccumulator }
     * 
     */
    public CosAccumulator createCosAccumulator() {
        return new CosAccumulator();
    }

    /**
     * Create an instance of {@link ArrayOfCosBalanceOrder }
     * 
     */
    public ArrayOfCosBalanceOrder createArrayOfCosBalanceOrder() {
        return new ArrayOfCosBalanceOrder();
    }

    /**
     * Create an instance of {@link CosBalanceOrder }
     * 
     */
    public CosBalanceOrder createCosBalanceOrder() {
        return new CosBalanceOrder();
    }

    /**
     * Create an instance of {@link ArrayOfPreCallThreshold }
     * 
     */
    public ArrayOfPreCallThreshold createArrayOfPreCallThreshold() {
        return new ArrayOfPreCallThreshold();
    }

    /**
     * Create an instance of {@link PreCallThreshold }
     * 
     */
    public PreCallThreshold createPreCallThreshold() {
        return new PreCallThreshold();
    }

    /**
     * Create an instance of {@link ArrayOfCOSFriend }
     * 
     */
    public ArrayOfCOSFriend createArrayOfCOSFriend() {
        return new ArrayOfCOSFriend();
    }

    /**
     * Create an instance of {@link COSFriend }
     * 
     */
    public COSFriend createCOSFriend() {
        return new COSFriend();
    }

    /**
     * Create an instance of {@link ArrayOfLifeCycle }
     * 
     */
    public ArrayOfLifeCycle createArrayOfLifeCycle() {
        return new ArrayOfLifeCycle();
    }

    /**
     * Create an instance of {@link LifeCycle }
     * 
     */
    public LifeCycle createLifeCycle() {
        return new LifeCycle();
    }

    /**
     * Create an instance of {@link CLASSOFSERVICEEXTENSIONDATA }
     * 
     */
    public CLASSOFSERVICEEXTENSIONDATA createCLASSOFSERVICEEXTENSIONDATA() {
        return new CLASSOFSERVICEEXTENSIONDATA();
    }

    /**
     * Create an instance of {@link ArrayOfCurrencyUnit }
     * 
     */
    public ArrayOfCurrencyUnit createArrayOfCurrencyUnit() {
        return new ArrayOfCurrencyUnit();
    }

    /**
     * Create an instance of {@link CurrencyUnit }
     * 
     */
    public CurrencyUnit createCurrencyUnit() {
        return new CurrencyUnit();
    }

    /**
     * Create an instance of {@link ArrayOfLoyaltyBonusPlan }
     * 
     */
    public ArrayOfLoyaltyBonusPlan createArrayOfLoyaltyBonusPlan() {
        return new ArrayOfLoyaltyBonusPlan();
    }

    /**
     * Create an instance of {@link LoyaltyBonusPlan }
     * 
     */
    public LoyaltyBonusPlan createLoyaltyBonusPlan() {
        return new LoyaltyBonusPlan();
    }

    /**
     * Create an instance of {@link ArrayOfAlcsOverrideDefinition }
     * 
     */
    public ArrayOfAlcsOverrideDefinition createArrayOfAlcsOverrideDefinition() {
        return new ArrayOfAlcsOverrideDefinition();
    }

    /**
     * Create an instance of {@link AlcsOverrideDefinition }
     * 
     */
    public AlcsOverrideDefinition createAlcsOverrideDefinition() {
        return new AlcsOverrideDefinition();
    }

    /**
     * Create an instance of {@link Identity }
     * 
     */
    public Identity createIdentity() {
        return new Identity();
    }

    /**
     * Create an instance of {@link ServiceParameter }
     * 
     */
    public ServiceParameter createServiceParameter() {
        return new ServiceParameter();
    }

    /**
     * Create an instance of {@link Range }
     * 
     */
    public Range createRange() {
        return new Range();
    }

    /**
     * Create an instance of {@link ArrayOfCurrencyConversion }
     * 
     */
    public ArrayOfCurrencyConversion createArrayOfCurrencyConversion() {
        return new ArrayOfCurrencyConversion();
    }

    /**
     * Create an instance of {@link CurrencyConversion }
     * 
     */
    public CurrencyConversion createCurrencyConversion() {
        return new CurrencyConversion();
    }

    /**
     * Create an instance of {@link PasswordCharacteristics }
     * 
     */
    public PasswordCharacteristics createPasswordCharacteristics() {
        return new PasswordCharacteristics();
    }

    /**
     * Create an instance of {@link ArrayOfLoyaltyBonusScale }
     * 
     */
    public ArrayOfLoyaltyBonusScale createArrayOfLoyaltyBonusScale() {
        return new ArrayOfLoyaltyBonusScale();
    }

    /**
     * Create an instance of {@link LoyaltyBonusScale }
     * 
     */
    public LoyaltyBonusScale createLoyaltyBonusScale() {
        return new LoyaltyBonusScale();
    }

    /**
     * Create an instance of {@link SubscriberHome }
     * 
     */
    public SubscriberHome createSubscriberHome() {
        return new SubscriberHome();
    }

    /**
     * Create an instance of {@link SUBSCRIBERINFOEXTENSIONDATA }
     * 
     */
    public SUBSCRIBERINFOEXTENSIONDATA createSUBSCRIBERINFOEXTENSIONDATA() {
        return new SUBSCRIBERINFOEXTENSIONDATA();
    }

    /**
     * Create an instance of {@link SubscriberPB }
     * 
     */
    public SubscriberPB createSubscriberPB() {
        return new SubscriberPB();
    }

    /**
     * Create an instance of {@link ArrayOfSubscriberPeriodicCharge }
     * 
     */
    public ArrayOfSubscriberPeriodicCharge createArrayOfSubscriberPeriodicCharge() {
        return new ArrayOfSubscriberPeriodicCharge();
    }

    /**
     * Create an instance of {@link SubscriberPeriodicCharge }
     * 
     */
    public SubscriberPeriodicCharge createSubscriberPeriodicCharge() {
        return new SubscriberPeriodicCharge();
    }

    /**
     * Create an instance of {@link SubscriberPPS }
     * 
     */
    public SubscriberPPS createSubscriberPPS() {
        return new SubscriberPPS();
    }

    /**
     * Create an instance of {@link SUBSCRIBEREXTENSIONDATA }
     * 
     */
    public SUBSCRIBEREXTENSIONDATA createSUBSCRIBEREXTENSIONDATA() {
        return new SUBSCRIBEREXTENSIONDATA();
    }

    /**
     * Create an instance of {@link AccumulatorModify }
     * 
     */
    public AccumulatorModify createAccumulatorModify() {
        return new AccumulatorModify();
    }

    /**
     * Create an instance of {@link AccumulatorBase }
     * 
     */
    public AccumulatorBase createAccumulatorBase() {
        return new AccumulatorBase();
    }

    /**
     * Create an instance of {@link BonusPlanModify }
     * 
     */
    public BonusPlanModify createBonusPlanModify() {
        return new BonusPlanModify();
    }

    /**
     * Create an instance of {@link BonusPlanEntity }
     * 
     */
    public BonusPlanEntity createBonusPlanEntity() {
        return new BonusPlanEntity();
    }

    /**
     * Create an instance of {@link LoyaltyBonusPlanModify }
     * 
     */
    public LoyaltyBonusPlanModify createLoyaltyBonusPlanModify() {
        return new LoyaltyBonusPlanModify();
    }

    /**
     * Create an instance of {@link ArrayOfBalanceEntityBase }
     * 
     */
    public ArrayOfBalanceEntityBase createArrayOfBalanceEntityBase() {
        return new ArrayOfBalanceEntityBase();
    }

    /**
     * Create an instance of {@link BalanceEntityBase }
     * 
     */
    public BalanceEntityBase createBalanceEntityBase() {
        return new BalanceEntityBase();
    }

    /**
     * Create an instance of {@link SubscriberSpecialHome }
     * 
     */
    public SubscriberSpecialHome createSubscriberSpecialHome() {
        return new SubscriberSpecialHome();
    }

    /**
     * Create an instance of {@link SubscriberHappyHour }
     * 
     */
    public SubscriberHappyHour createSubscriberHappyHour() {
        return new SubscriberHappyHour();
    }

    /**
     * Create an instance of {@link ArrayOfMTRItem }
     * 
     */
    public ArrayOfMTRItem createArrayOfMTRItem() {
        return new ArrayOfMTRItem();
    }

    /**
     * Create an instance of {@link MTRItem }
     * 
     */
    public MTRItem createMTRItem() {
        return new MTRItem();
    }

    /**
     * Create an instance of {@link DeltaBalance }
     * 
     */
    public DeltaBalance createDeltaBalance() {
        return new DeltaBalance();
    }

    /**
     * Create an instance of {@link BalanceCreditAccount }
     * 
     */
    public BalanceCreditAccount createBalanceCreditAccount() {
        return new BalanceCreditAccount();
    }

    /**
     * Create an instance of {@link SubscriberEntity }
     * 
     */
    public SubscriberEntity createSubscriberEntity() {
        return new SubscriberEntity();
    }

    /**
     * Create an instance of {@link ArrayOfBalanceEntity }
     * 
     */
    public ArrayOfBalanceEntity createArrayOfBalanceEntity() {
        return new ArrayOfBalanceEntity();
    }

    /**
     * Create an instance of {@link BalanceEntity }
     * 
     */
    public BalanceEntity createBalanceEntity() {
        return new BalanceEntity();
    }

    /**
     * Create an instance of {@link AccumulatorEntity }
     * 
     */
    public AccumulatorEntity createAccumulatorEntity() {
        return new AccumulatorEntity();
    }

    /**
     * Create an instance of {@link SubscribedOffer }
     * 
     */
    public SubscribedOffer createSubscribedOffer() {
        return new SubscribedOffer();
    }

    /**
     * Create an instance of {@link ArrayOfCallHistory }
     * 
     */
    public ArrayOfCallHistory createArrayOfCallHistory() {
        return new ArrayOfCallHistory();
    }

    /**
     * Create an instance of {@link CALLHISTORYEXTENSIONDATA }
     * 
     */
    public CALLHISTORYEXTENSIONDATA createCALLHISTORYEXTENSIONDATA() {
        return new CALLHISTORYEXTENSIONDATA();
    }

    /**
     * Create an instance of {@link ArrayOfAccumulatorHistory }
     * 
     */
    public ArrayOfAccumulatorHistory createArrayOfAccumulatorHistory() {
        return new ArrayOfAccumulatorHistory();
    }

    /**
     * Create an instance of {@link AccumulatorHistory }
     * 
     */
    public AccumulatorHistory createAccumulatorHistory() {
        return new AccumulatorHistory();
    }

    /**
     * Create an instance of {@link FastCallHistory }
     * 
     */
    public FastCallHistory createFastCallHistory() {
        return new FastCallHistory();
    }

    /**
     * Create an instance of {@link ArrayOfMonetaryTransactionRecord }
     * 
     */
    public ArrayOfMonetaryTransactionRecord createArrayOfMonetaryTransactionRecord() {
        return new ArrayOfMonetaryTransactionRecord();
    }

    /**
     * Create an instance of {@link MTRHISTORYEXTENSIONDATA }
     * 
     */
    public MTRHISTORYEXTENSIONDATA createMTRHISTORYEXTENSIONDATA() {
        return new MTRHISTORYEXTENSIONDATA();
    }

    /**
     * Create an instance of {@link FastMonetaryTransactionRecord }
     * 
     */
    public FastMonetaryTransactionRecord createFastMonetaryTransactionRecord() {
        return new FastMonetaryTransactionRecord();
    }

    /**
     * Create an instance of {@link PSTransaction }
     * 
     */
    public PSTransaction createPSTransaction() {
        return new PSTransaction();
    }

    /**
     * Create an instance of {@link FastPSTransaction }
     * 
     */
    public FastPSTransaction createFastPSTransaction() {
        return new FastPSTransaction();
    }

    /**
     * Create an instance of {@link ArrayOfRechargeHistory }
     * 
     */
    public ArrayOfRechargeHistory createArrayOfRechargeHistory() {
        return new ArrayOfRechargeHistory();
    }

    /**
     * Create an instance of {@link RECHARGEHISTORYEXTENSIONDATA }
     * 
     */
    public RECHARGEHISTORYEXTENSIONDATA createRECHARGEHISTORYEXTENSIONDATA() {
        return new RECHARGEHISTORYEXTENSIONDATA();
    }

    /**
     * Create an instance of {@link FastRechargeHistory }
     * 
     */
    public FastRechargeHistory createFastRechargeHistory() {
        return new FastRechargeHistory();
    }

    /**
     * Create an instance of {@link ArrayOfOSAHistory }
     * 
     */
    public ArrayOfOSAHistory createArrayOfOSAHistory() {
        return new ArrayOfOSAHistory();
    }

    /**
     * Create an instance of {@link OSAHISTORYEXTENSIONDATA }
     * 
     */
    public OSAHISTORYEXTENSIONDATA createOSAHISTORYEXTENSIONDATA() {
        return new OSAHISTORYEXTENSIONDATA();
    }

    /**
     * Create an instance of {@link FastOSAHistory }
     * 
     */
    public FastOSAHistory createFastOSAHistory() {
        return new FastOSAHistory();
    }

    /**
     * Create an instance of {@link ArrayOfOfferHistoryRecord }
     * 
     */
    public ArrayOfOfferHistoryRecord createArrayOfOfferHistoryRecord() {
        return new ArrayOfOfferHistoryRecord();
    }

    /**
     * Create an instance of {@link OfferHistoryRecord }
     * 
     */
    public OfferHistoryRecord createOfferHistoryRecord() {
        return new OfferHistoryRecord();
    }

    /**
     * Create an instance of {@link CUGMembers }
     * 
     */
    public CUGMembers createCUGMembers() {
        return new CUGMembers();
    }

    /**
     * Create an instance of {@link ArrayOfReservation }
     * 
     */
    public ArrayOfReservation createArrayOfReservation() {
        return new ArrayOfReservation();
    }

    /**
     * Create an instance of {@link Reservation }
     * 
     */
    public Reservation createReservation() {
        return new Reservation();
    }

    /**
     * Create an instance of {@link ArrayOfAccumulatorBase }
     * 
     */
    public ArrayOfAccumulatorBase createArrayOfAccumulatorBase() {
        return new ArrayOfAccumulatorBase();
    }

    /**
     * Create an instance of {@link ArrayOfReservationAmount }
     * 
     */
    public ArrayOfReservationAmount createArrayOfReservationAmount() {
        return new ArrayOfReservationAmount();
    }

    /**
     * Create an instance of {@link ReservationAmount }
     * 
     */
    public ReservationAmount createReservationAmount() {
        return new ReservationAmount();
    }

    /**
     * Create an instance of {@link ArrayOfIdentityHistory }
     * 
     */
    public ArrayOfIdentityHistory createArrayOfIdentityHistory() {
        return new ArrayOfIdentityHistory();
    }

    /**
     * Create an instance of {@link IdentityHistory }
     * 
     */
    public IdentityHistory createIdentityHistory() {
        return new IdentityHistory();
    }

    /**
     * Create an instance of {@link ArrayOfCircleMembership }
     * 
     */
    public ArrayOfCircleMembership createArrayOfCircleMembership() {
        return new ArrayOfCircleMembership();
    }

    /**
     * Create an instance of {@link CircleMembership }
     * 
     */
    public CircleMembership createCircleMembership() {
        return new CircleMembership();
    }

    /**
     * Create an instance of {@link DIAMETEROCSHISTORYEXTENSIONDATA }
     * 
     */
    public DIAMETEROCSHISTORYEXTENSIONDATA createDIAMETEROCSHISTORYEXTENSIONDATA() {
        return new DIAMETEROCSHISTORYEXTENSIONDATA();
    }

    /**
     * Create an instance of {@link FandFPhonebookHistory }
     * 
     */
    public FandFPhonebookHistory createFandFPhonebookHistory() {
        return new FandFPhonebookHistory();
    }

    /**
     * Create an instance of {@link IdentityStatus }
     * 
     */
    public IdentityStatus createIdentityStatus() {
        return new IdentityStatus();
    }

    /**
     * Create an instance of {@link GroupAccountBase }
     * 
     */
    public GroupAccountBase createGroupAccountBase() {
        return new GroupAccountBase();
    }

    /**
     * Create an instance of {@link ArrayOfGroupAccountSpendingLimit }
     * 
     */
    public ArrayOfGroupAccountSpendingLimit createArrayOfGroupAccountSpendingLimit() {
        return new ArrayOfGroupAccountSpendingLimit();
    }

    /**
     * Create an instance of {@link GroupAccountSpendingLimit }
     * 
     */
    public GroupAccountSpendingLimit createGroupAccountSpendingLimit() {
        return new GroupAccountSpendingLimit();
    }

    /**
     * Create an instance of {@link ArrayOfInvoiceAmount }
     * 
     */
    public ArrayOfInvoiceAmount createArrayOfInvoiceAmount() {
        return new ArrayOfInvoiceAmount();
    }

    /**
     * Create an instance of {@link InvoiceAmount }
     * 
     */
    public InvoiceAmount createInvoiceAmount() {
        return new InvoiceAmount();
    }

    /**
     * Create an instance of {@link AccessNumberInfo }
     * 
     */
    public AccessNumberInfo createAccessNumberInfo() {
        return new AccessNumberInfo();
    }

    /**
     * Create an instance of {@link CurrencyConversionRetrieve }
     * 
     */
    public CurrencyConversionRetrieve createCurrencyConversionRetrieve() {
        return new CurrencyConversionRetrieve();
    }

    /**
     * Create an instance of {@link CreditAccumulator2 }
     * 
     */
    public CreditAccumulator2 createCreditAccumulator2() {
        return new CreditAccumulator2();
    }

    /**
     * Create an instance of {@link CallingCircle }
     * 
     */
    public CallingCircle createCallingCircle() {
        return new CallingCircle();
    }

    /**
     * Create an instance of {@link CircleMemberOperation }
     * 
     */
    public CircleMemberOperation createCircleMemberOperation() {
        return new CircleMemberOperation();
    }

    /**
     * Create an instance of {@link CircleMember }
     * 
     */
    public CircleMember createCircleMember() {
        return new CircleMember();
    }

    /**
     * Create an instance of {@link CircleOperationResponse }
     * 
     */
    public CircleOperationResponse createCircleOperationResponse() {
        return new CircleOperationResponse();
    }

    /**
     * Create an instance of {@link IdentitySpecficData }
     * 
     */
    public IdentitySpecficData createIdentitySpecficData() {
        return new IdentitySpecficData();
    }

    /**
     * Create an instance of {@link DiameterOCSHistory.ExtensionDataRaw }
     * 
     */
    public DiameterOCSHistory.ExtensionDataRaw createDiameterOCSHistoryExtensionDataRaw() {
        return new DiameterOCSHistory.ExtensionDataRaw();
    }

    /**
     * Create an instance of {@link OSAHistory.ExtensionDataRaw }
     * 
     */
    public OSAHistory.ExtensionDataRaw createOSAHistoryExtensionDataRaw() {
        return new OSAHistory.ExtensionDataRaw();
    }

    /**
     * Create an instance of {@link RechargeHistory.ExtensionDataRaw }
     * 
     */
    public RechargeHistory.ExtensionDataRaw createRechargeHistoryExtensionDataRaw() {
        return new RechargeHistory.ExtensionDataRaw();
    }

    /**
     * Create an instance of {@link MonetaryTransactionRecord.ExtensionDataRaw }
     * 
     */
    public MonetaryTransactionRecord.ExtensionDataRaw createMonetaryTransactionRecordExtensionDataRaw() {
        return new MonetaryTransactionRecord.ExtensionDataRaw();
    }

    /**
     * Create an instance of {@link CallHistory.ExtensionDataRaw }
     * 
     */
    public CallHistory.ExtensionDataRaw createCallHistoryExtensionDataRaw() {
        return new CallHistory.ExtensionDataRaw();
    }

    /**
     * Create an instance of {@link SubscriberMainBase.ExtensionDataRaw }
     * 
     */
    public SubscriberMainBase.ExtensionDataRaw createSubscriberMainBaseExtensionDataRaw() {
        return new SubscriberMainBase.ExtensionDataRaw();
    }

    /**
     * Create an instance of {@link SubscriberInfo.ExtensionDataRaw }
     * 
     */
    public SubscriberInfo.ExtensionDataRaw createSubscriberInfoExtensionDataRaw() {
        return new SubscriberInfo.ExtensionDataRaw();
    }

    /**
     * Create an instance of {@link ClassOfService.ExtensionDataRaw }
     * 
     */
    public ClassOfService.ExtensionDataRaw createClassOfServiceExtensionDataRaw() {
        return new ClassOfService.ExtensionDataRaw();
    }

    /**
     * Create an instance of {@link DiscountPlan.ExtensionDataRaw }
     * 
     */
    public DiscountPlan.ExtensionDataRaw createDiscountPlanExtensionDataRaw() {
        return new DiscountPlan.ExtensionDataRaw();
    }

    /**
     * Create an instance of {@link BonusPlan.ExtensionDataRaw }
     * 
     */
    public BonusPlan.ExtensionDataRaw createBonusPlanExtensionDataRaw() {
        return new BonusPlan.ExtensionDataRaw();
    }

    /**
     * Create an instance of {@link ClientCache.CachedTablesRaw }
     * 
     */
    public ClientCache.CachedTablesRaw createClientCacheCachedTablesRaw() {
        return new ClientCache.CachedTablesRaw();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VersionInfoHeader }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://comverse-in.com/prepaid/ccws", name = "VersionInfoHeader")
    public JAXBElement<VersionInfoHeader> createVersionInfoHeader(VersionInfoHeader value) {
        return new JAXBElement<VersionInfoHeader>(_VersionInfoHeader_QNAME, VersionInfoHeader.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MTRDataArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://comverse-in.com/prepaid/ccws", name = "MTRDataArray")
    public JAXBElement<MTRDataArray> createMTRDataArray(MTRDataArray value) {
        return new JAXBElement<MTRDataArray>(_MTRDataArray_QNAME, MTRDataArray.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SourceInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://comverse-in.com/prepaid/ccws", name = "SourceInfo")
    public JAXBElement<SourceInfo> createSourceInfo(SourceInfo value) {
        return new JAXBElement<SourceInfo>(_SourceInfo_QNAME, SourceInfo.class, null, value);
    }

}
