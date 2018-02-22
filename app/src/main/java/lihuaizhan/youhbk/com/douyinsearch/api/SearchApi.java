package lihuaizhan.youhbk.com.douyinsearch.api;

import io.reactivex.Flowable;
import lihuaizhan.youhbk.com.douyinsearch.bean.SearchBanner;
import lihuaizhan.youhbk.com.douyinsearch.bean.SearchBean;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2018/2/22.
 */

public interface SearchApi {
    @GET("aweme/v1/hot/search/?retry_type=no_retry&iid=23796080841&device_id=42386607829&ac=wifi&channel=xiaomi&aid=1128&app_name=aweme&version_code=171&version_name=1.7.1&device_platform=android&ssmix=a&device_type=Redmi+Note+4&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0&uuid=863411038560129&openudid=87f33cdff2475c29&manifest_version_code=171&resolution=1080*1920&dpi=480&update_version_code=1712&_rticket=1516849735338&ts=1516849735&as=a185f4765754ca2a395107&cp=4348ab517e966ba8e1grmh&mas=00f0e8f97bdd1c96dcdfedefc70dc26152ec0c8cac9ccc864c86c6")
    Flowable<SearchBean> getData();
    @GET("aweme/v1/find/?retry_type=no_retry&iid=23796080841&device_id=42386607829&ac=wifi&channel=xiaomi&aid=1128&app_name=aweme&version_code=171&version_name=1.7.1&device_platform=android&ssmix=a&device_type=Redmi+Note+4&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0&uuid=863411038560129&openudid=87f33cdff2475c29&manifest_version_code=171&resolution=1080*1920&dpi=480&update_version_code=1712&_rticket=1516849735339&ts=1516849735&as=a1452436f7343acae92252&cp=4c4da1527e9867aee1zatt&mas=00d8b37a285b651e88071f90d749dc29144cac4c4c9ca686c686cc")
    Flowable<SearchBanner> getBanner();
}
