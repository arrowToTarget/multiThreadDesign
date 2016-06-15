package com.lewis.compare.vo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangminghua on 2016/6/15.
 */
public class ServiceNameConfig {

    private static final List<String> productAppServiceNameList = new LinkedList<String>();
    private static final List<String> priceAppServiceNameList = new LinkedList<String>();

    public static final String PRODUCT_getDetail_NAME="BOH.NM.ProductController.getDetail";
    public static final String PRODUCT_getBatchDetails_NAME="BOH.NM.ProductController.getBatchDetails";
    public static final String PRODUCT_queryCommonProductInfos_NAME="BOH.NM.ProductController.queryCommonProductInfos";
    public static final String PRODUCT_queryProductInstallment_NAME="BOH.NM.ProductController.queryProductInstallment";
    public static final String PRODUCT_getProductType_NAME="BOH.NM.ProductController.getProductType";
    public static final String PRODUCT_getProductGuideInfo_NAME="BOH.NM.GuideController.getProductGuideInfo";
    public static final String PRODUCT_getScenicInfo_NAME="BOH.NM.ProductController.getScenicInfo";
    public static final String PRODUCT_queryJourneyAndResInfo_NAME="BOH.NM.ProductController.queryJourneyAndResInfo";
    public static final String PRODUCT_queryNewByOriginal_NAME="BOH.NM.ProductController.queryNewByOriginal";
    public static final String PRODUCT_getMultiJourneyInfoAndTranspInfo_NAME="BOH.NM.ProductController.getMultiJourneyInfoAndTranspInfo";
    public static final String PRODUCT_getQuestionAndAnswer_NAME="BOH.NM.QuestionAndAnswerContoller.getQuestionAndAnswer";
    public static final String PRODUCT_getBatchStatus_NAME="BOH.NM.ProductController.getBatchStatus";
    public static final String PRODUCT_getBatchScenicInfo_NAME="BOH.NM.ProductController.getBatchScenicInfo";
    public static final String PRODUCT_getNoticeInfo_NAME="BOH.NM.ProductController.getNoticeInfo";
    public static final String PRODUCT_getBatchAgencies_NAME="BOH.NM.ProductController.getBatchAgencies";
    public static final String PRODUCT_getInsuranceInfo_NAME="BOH.NM.ProductController.getInsuranceInfo";
    public static final String PRODUCT_queryMainRouteId_NAME="BOH.NM.ProductController.queryMainRouteId";
    public static final String PRODUCT_queryList_NAME="BOH.NM.ProductController.queryList";
    public static final String PRODUCT_queryCount_NAME="BOH.NM.ProductController.queryCount";
    public static final String PRODUCT_getGuideList_NAME="BOH.NM.GuideController.getGuideList";

    public static final String PRODUCT_getCategoryInfo_NAME="BOH.NM.CategoryByDepartCityControler.getCategoryInfo";
    public static final String PRODUCT_queryHotelGrouplist_NAME="BOH.NM.HotelGroupController.queryHotelGrouplist";
    public static final String PRODUCT_getHotelGroupsummary_NAME="BOH.NM.HotelGroupController.getHotelGroupsummary";
    public static final String PRODUCT_getQuestionType_NAME="BOH.NM.QuestionAndAnswerContoller.getQuestionType";
    public static final String PRODUCT_baokuanProduct_NAME="BOH.NM.ProductController.baokuanProduct";
    public static final String PRODUCT_contractLoseInfoQuery_NAME="BOH.NM.ProductController.contractLoseInfoQuery";
    public static final String PRODUCT_getByCityCode_NAME="BOH.NM.CompanyController.getByCityCode";
    public static final String PRODUCT_queryOriginalByNew_NAME="BOH.NM.ProductController.queryOriginalByNew";
    public static final String PRODUCT_getCities_NAME="BOH.NM.CityQueryControler.getCities";
    public static final String PRODUCT_getHotelGroupHotList_NAME="BOH.NM.HotelGroupController.getHotelGroupHotList";
    public static final String PRODUCT_queryProductTransportationInfo_NAME="BOH.NM.ProductController.queryProductTransportationInfo";
    public static final String PRODUCT_getByResIds_NAME="BOH.NM.NgResourceController.getByResIds";
    public static final String PRODUCT_getDetailResources_NAME="BOH.NM.ProductController.getDetailResources";
    public static final String PRODUCT_queryAirportCity_NAME="BOH.NM.FlightTicketChannelController.queryAirportCity";
    public static final String PRODUCT_TrainTicketChannelController_getCities_NAME="BOH.NM.TrainTicketChannelController.getCities";
    public static final String PRODUCT_queryMatchedInsurances_NAME="BOH.NM.ProductController.queryMatchedInsurances";
    public static final String PRODUCT_getConsulateAndConsularDistrictInfo_NAME="BOH.NM.NgResourceController.getConsulateAndConsularDistrictInfo";
    public static final String PRODUCT_queryHotelDetail_NAME="BOH.NM.HotelChannelController.queryHotelDetail";
    public static final String PRODUCT_queryCruiseResDetail_NAME="BOH.NM.NgResourceController.queryCruiseResDetail";
    public static final String PRODUCT_queryResList_NAME="BOH.NM.NgResourceController.queryResList";

    public static final String PRODUCT_queryFlightIndivPriceCalendar_NAME="BOH.NM.FlightTicketChannelController.queryFlightIndivPriceCalendar";
    public static final String PRODUCT_queryResourceRelation_NAME="BOH.NM.NgResourceController.queryResourceRelation";
    public static final String PRODUCT_queryFlightIndivRecommended_NAME="BOH.NM.FlightTicketChannelController.queryFlightIndivRecommended";
    public static final String PRODUCT_queryHotCity_NAME="BOH.NM.FlightTicketChannelController.queryHotCity";
    public static final String PRODUCT_flightIndivSpecialOffer_NAME="BOH.NM.FlightTicketChannelController.flightIndivSpecialOffer";
    public static final String PRODUCT_queryFlightIndivIntLowest_NAME="BOH.NM.NgResourceController.queryFlightIndivIntLowest";
    public static final String PRODUCT_searchFlightInt_NAME="BOH.NM.FlightTicketChannelController.searchFlightInt";
    public static final String PRODUCT_queryStockResourceTotalOccupationOutLeftInfo_NAME="BOH.NM.NgResourceController.queryStockResourceTotalOccupationOutLeftInfo";
    public static final String PRODUCT_queryRatePlanV3_NAME="BOH.NM.HotelChannelController.queryRatePlanV3";
    public static final String PRODUCT_searchFlightIntNew_NAME="BOH.NM.FlightTicketChannelController.searchFlightIntNew";
    public static final String PRODUCT_flightIndivVerify_NAME="BOH.NM.FlightTicketChannelController.flightIndivVerify";
    public static final String PRODUCT_fuzzyMatch_NAME="BOH.NM.FlightTicketChannelController.fuzzyMatch";
    public static final String PRODUCT_queryHotelConfigList_NAME="BOH.NM.HotelChannelController.queryHotelConfigList";
    public static final String PRODUCT_queryFlightIndiv_NAME="BOH.NM.NgResourceController.queryFlightIndiv";
    public static final String PRODUCT_queryHotelList_NAME="BOH.NM.HotelChannelController.queryHotelList";
    public static final String PRODUCT_queryBestBuy_NAME="BOH.NM.FlightTicketChannelController.queryBestBuy";
    public static final String PRODUCT_checkCabinAndPrice_NAME="BOH.NM.FlightTicketChannelController.checkCabinAndPrice";

    public static final String PRODUCT_queryFlightIndivRefundAndReissue_NAME="BOH.NM.FlightTicketChannelController.queryFlightIndivRefundAndReissue";
    public static final String PRODUCT_saveResource_NAME="BOH.NM.HotelChannelController.saveResource";
    public static final String PRODUCT_queryResourceDetailV3_NAME="BOH.NM.HotelChannelController.queryResourceDetailV3";
    public static final String PRODUCT_queryFareRemarkNew_NAME="BOH.NM.FlightTicketChannelController.queryFareRemarkNew";
    public static final String PRODUCT_queryFareRemark_NAME="BOH.NM.FlightTicketChannelController.queryFareRemark";
    public static final String PRODUCT_queryFlightSpecialInquiry_NAME="BOH.NM.FlightTicketChannelController.queryFlightSpecialInquiry";
    public static final String PRODUCT_queryInternationalHotelDetail_NAME="BOH.NM.HotelChannelController.queryInternationalHotelDetail";
    public static final String PRODUCT_flightIndivPreferential_NAME="BOH.NM.FlightTicketChannelController.flightIndivPreferential";
    public static final String PRODUCT_queryInternationalHotelBookingInfo_NAME="BOH.NM.HotelChannelController.queryInternationalHotelBookingInfo";
    public static final String PRODUCT_queryConfigLowerPrice_NAME="BOH.NM.HotelChannelController.queryConfigLowerPrice";
    public static final String PRODUCT_queryFlightIndivPreferential_NAME="BOH.NM.NgResourceController.queryFlightIndivPreferential";
    public static final String PRODUCT_queryRuleById_NAME="BOH.NM.FlightTicketChannelController.queryRuleById";
    public static final String PRODUCT_queryTrainInfo_NAME="BOH.NM.TrainTicketChannelController.queryTrainInfo";
    public static final String PRODUCT_baokuanProductRes_NAME="BOH.NM.ProductController.baokuanProductRes";
    public static final String PRODUCT_baokuanProductUpgrade_NAME="BOH.NM.ProductController.baokuanProductUpgrade";
    public static final String PRODUCT_queryStartPrice_NAME="BOH.NM.FlightTicketChannelController.queryStartPrice";
    public static final String PRODUCT_queryFlightIndivInt_NAME="BOH.NM.NgResourceController.queryFlightIndivInt";
    static {
        productAppServiceNameList.add(PRODUCT_queryFlightIndivPriceCalendar_NAME);
        productAppServiceNameList.add(PRODUCT_queryResourceRelation_NAME);
        productAppServiceNameList.add(PRODUCT_queryFlightIndivRecommended_NAME);
        productAppServiceNameList.add(PRODUCT_queryHotCity_NAME);
        productAppServiceNameList.add(PRODUCT_flightIndivSpecialOffer_NAME);
        productAppServiceNameList.add(PRODUCT_queryFlightIndivIntLowest_NAME);
        productAppServiceNameList.add(PRODUCT_searchFlightInt_NAME);
        productAppServiceNameList.add(PRODUCT_queryStockResourceTotalOccupationOutLeftInfo_NAME);
        productAppServiceNameList.add(PRODUCT_queryRatePlanV3_NAME);
        productAppServiceNameList.add(PRODUCT_searchFlightIntNew_NAME);
        productAppServiceNameList.add(PRODUCT_flightIndivVerify_NAME);
        productAppServiceNameList.add(PRODUCT_fuzzyMatch_NAME);
        productAppServiceNameList.add(PRODUCT_queryHotelConfigList_NAME);
        productAppServiceNameList.add(PRODUCT_queryFlightIndiv_NAME);
        productAppServiceNameList.add(PRODUCT_queryHotelList_NAME);
        productAppServiceNameList.add(PRODUCT_queryBestBuy_NAME);
        productAppServiceNameList.add(PRODUCT_checkCabinAndPrice_NAME);

        productAppServiceNameList.add(PRODUCT_getCategoryInfo_NAME);
        productAppServiceNameList.add(PRODUCT_queryHotelGrouplist_NAME);
        productAppServiceNameList.add(PRODUCT_getHotelGroupsummary_NAME);
        productAppServiceNameList.add(PRODUCT_getQuestionType_NAME);
        productAppServiceNameList.add(PRODUCT_baokuanProduct_NAME);
        productAppServiceNameList.add(PRODUCT_contractLoseInfoQuery_NAME);
        productAppServiceNameList.add(PRODUCT_getByCityCode_NAME);
        productAppServiceNameList.add(PRODUCT_queryOriginalByNew_NAME);
        productAppServiceNameList.add(PRODUCT_getCities_NAME);
        productAppServiceNameList.add(PRODUCT_getHotelGroupHotList_NAME);
        productAppServiceNameList.add(PRODUCT_queryProductTransportationInfo_NAME);
        productAppServiceNameList.add(PRODUCT_getByResIds_NAME);
        productAppServiceNameList.add(PRODUCT_getDetailResources_NAME);
        productAppServiceNameList.add(PRODUCT_queryAirportCity_NAME);
        productAppServiceNameList.add(PRODUCT_TrainTicketChannelController_getCities_NAME);
        productAppServiceNameList.add(PRODUCT_queryMatchedInsurances_NAME);
        productAppServiceNameList.add(PRODUCT_getConsulateAndConsularDistrictInfo_NAME);
        productAppServiceNameList.add(PRODUCT_queryHotelDetail_NAME);
        productAppServiceNameList.add(PRODUCT_queryCruiseResDetail_NAME);
        productAppServiceNameList.add(PRODUCT_queryResList_NAME);

        productAppServiceNameList.add(PRODUCT_getDetail_NAME);
        productAppServiceNameList.add(PRODUCT_getBatchDetails_NAME);
        productAppServiceNameList.add(PRODUCT_queryCommonProductInfos_NAME);
        productAppServiceNameList.add(PRODUCT_queryProductInstallment_NAME);
        productAppServiceNameList.add(PRODUCT_getProductType_NAME);
        productAppServiceNameList.add(PRODUCT_getProductGuideInfo_NAME);
        productAppServiceNameList.add(PRODUCT_getScenicInfo_NAME);
        productAppServiceNameList.add(PRODUCT_queryJourneyAndResInfo_NAME);
        productAppServiceNameList.add(PRODUCT_queryNewByOriginal_NAME);
        productAppServiceNameList.add(PRODUCT_getMultiJourneyInfoAndTranspInfo_NAME);
        productAppServiceNameList.add(PRODUCT_getQuestionAndAnswer_NAME);
        productAppServiceNameList.add(PRODUCT_getBatchStatus_NAME);
        productAppServiceNameList.add(PRODUCT_getBatchScenicInfo_NAME);
        productAppServiceNameList.add(PRODUCT_getNoticeInfo_NAME);
        productAppServiceNameList.add(PRODUCT_getBatchAgencies_NAME);
        productAppServiceNameList.add(PRODUCT_getInsuranceInfo_NAME);
        productAppServiceNameList.add(PRODUCT_queryMainRouteId_NAME);
        productAppServiceNameList.add(PRODUCT_queryList_NAME);
        productAppServiceNameList.add(PRODUCT_queryCount_NAME);
        productAppServiceNameList.add(PRODUCT_getGuideList_NAME);

        productAppServiceNameList.add(PRODUCT_queryFlightIndivRefundAndReissue_NAME);
        productAppServiceNameList.add(PRODUCT_saveResource_NAME);
        productAppServiceNameList.add(PRODUCT_queryResourceDetailV3_NAME);
        productAppServiceNameList.add(PRODUCT_queryFareRemarkNew_NAME);
        productAppServiceNameList.add(PRODUCT_queryFareRemark_NAME);
        productAppServiceNameList.add(PRODUCT_queryFlightSpecialInquiry_NAME);
        productAppServiceNameList.add(PRODUCT_queryInternationalHotelDetail_NAME);
        productAppServiceNameList.add(PRODUCT_flightIndivPreferential_NAME);
        productAppServiceNameList.add(PRODUCT_queryInternationalHotelBookingInfo_NAME);
        productAppServiceNameList.add(PRODUCT_queryConfigLowerPrice_NAME);
        productAppServiceNameList.add(PRODUCT_queryFlightIndivPreferential_NAME);
        productAppServiceNameList.add(PRODUCT_queryRuleById_NAME);
        productAppServiceNameList.add(PRODUCT_queryTrainInfo_NAME);
        productAppServiceNameList.add(PRODUCT_baokuanProductRes_NAME);
        productAppServiceNameList.add(PRODUCT_baokuanProductUpgrade_NAME);
        productAppServiceNameList.add(PRODUCT_queryStartPrice_NAME);
        productAppServiceNameList.add(PRODUCT_queryFlightIndivInt_NAME);
    }

    public static final String PRICE_getPriceCalendar_Name="BOH.NM.ProductController.getPriceCalendar";
    public static final String PRICE_queryProductStartPrice_Name="BOH.NM.ProductController.queryProductStartPrice";
    public static final String PRICE_queryProductPromotionInfo_Name="BOH.NM.ProductController.queryProductPromotionInfo";
    public static final String PRICE_queryDepartureCityInfoWithPrice_Name="BOH.NM.ProductController.queryDepartureCityInfoWithPrice";
    public static final String PRICE_getBoss3ResCalendar_Name="BOH.NM.NgResourceController.getBoss3ResCalendar";
    public static final String PRICE_queryHotelPrices_Name="BOH.NM.ProductController.queryHotelPrices";
    public static final String PRICE_queryFlightLowestCalendar_Name="BOH.NM.NgResourceController.queryFlightLowestCalendar";
    public static final String PRICE_queryCostCalendar_Name="BOH.NM.ProductController.queryCostCalendar";
    public static final String PRICE_queryProductPromotionStartPrice_Name="BOH.NM.ProductController.queryProductPromotionStartPrice";
    public static final String PRICE_getDistributionPriceCalendar_Name="BOH.NM.ProductController.getDistributionPriceCalendar";
    public static final String PRICE_queryLocalHotelPrices_Name="BOH.NM.HotelChannelController.queryLocalHotelPrices";
    public static final String PRICE_queryProductDistributionStartPrice_Name="BOH.NM.ProductController.queryProductDistributionStartPrice";
    public static final String PRICE_getCombinationCalendar_Name="BOH.NM.ProductController.getCombinationCalendar";
    public static final String PRICE_queryResCalendar_Name="BOH.NM.NgResourceController.queryResCalendar";

    static {
        priceAppServiceNameList.add(PRICE_getPriceCalendar_Name);
        priceAppServiceNameList.add(PRICE_queryProductStartPrice_Name);
        priceAppServiceNameList.add(PRICE_queryProductPromotionInfo_Name);
        priceAppServiceNameList.add(PRICE_queryDepartureCityInfoWithPrice_Name);
        priceAppServiceNameList.add(PRICE_getBoss3ResCalendar_Name);
        priceAppServiceNameList.add(PRICE_queryHotelPrices_Name);
        priceAppServiceNameList.add(PRICE_queryFlightLowestCalendar_Name);
        priceAppServiceNameList.add(PRICE_queryCostCalendar_Name);
        priceAppServiceNameList.add(PRICE_queryProductPromotionStartPrice_Name);
        priceAppServiceNameList.add(PRICE_getDistributionPriceCalendar_Name);
        priceAppServiceNameList.add(PRICE_queryLocalHotelPrices_Name);
        priceAppServiceNameList.add(PRICE_queryProductDistributionStartPrice_Name);
        priceAppServiceNameList.add(PRICE_getCombinationCalendar_Name);
        priceAppServiceNameList.add(PRICE_queryResCalendar_Name);
    }





}
