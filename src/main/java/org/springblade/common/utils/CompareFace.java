package org.springblade.common.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.facebody.model.v20191230.CompareFaceRequest;
import com.aliyuncs.facebody.model.v20191230.CompareFaceResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;

/**
 * @ClassName: CompareFace
 * @Description:
 * @Date: 2021/6/4 10:58
 */
public class CompareFace {

    //创建 CompareFace 的一个对象
    private static CompareFace compareFace = new CompareFace();

    private boolean results;

    public void setResults(boolean results) {
        this.results = results;
    }

    public boolean isResults() {
        return results;
    }

    public static boolean compareFace(String imageURLA, String imageURLB) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-shanghai", "LTAI5tDAAQ9SVwoeAEafYNmy", "p9OBKcgaj3PX6uD60NTlvOblnNNv6V");
        IAcsClient client = new DefaultAcsClient(profile);
        CompareFaceRequest request = new CompareFaceRequest();

//        request.setImageURLA("https://cvit-a419-uwithwind.oss-cn-shanghai.aliyuncs.com/test/a.jpg");
//        request.setImageURLB("https://cvit-a419-uwithwind.oss-cn-shanghai.aliyuncs.com/test/b.jpg");
        request.setImageURLA(imageURLA);
        request.setImageURLB(imageURLB);

        try {
            CompareFaceResponse response = client.getAcsResponse(request);
            double confidence = response.getData().getConfidence();
            if (confidence >= 60) {
                compareFace.setResults(true);
            } else {
                compareFace.setResults(false);
            }
            //控制台输出响应json
            System.out.println(new Gson().toJson(response));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
        return compareFace.isResults();
    }

}
