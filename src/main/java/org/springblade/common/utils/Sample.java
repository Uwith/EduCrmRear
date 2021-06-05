// This file is auto-generated, don't edit it. Thanks.
package org.springblade.common.utils;

import com.aliyun.facebody20191230.models.*;
import com.aliyun.tea.TeaException;
import com.aliyun.tea.TeaModel;
import com.aliyun.teaopenapi.models.Config;

public class Sample {

    /**
     * 使用AK&SK初始化账号Client
//     * @param CreateClientRequestBody
     * @return Facebody
     * @throws Exception
     */
    public static com.aliyun.facebody20191230.Client createClient(String regionId) throws Exception {
        Config config = new Config();
        // 您的AccessKey ID
        config.accessKeyId = com.aliyun.darabonba.env.EnvClient.getEnv("ACCESS_KEY_ID");
        // 您的AccessKey Secret
        config.accessKeySecret = com.aliyun.darabonba.env.EnvClient.getEnv("ACCESS_KEY_SECRET");
        // 您的可用区ID
        config.regionId = regionId;
        return new com.aliyun.facebody20191230.Client(config);
    }

    /**
     * 创建人脸数据库
     * @param client
     * @param dbName
     * @return void
     * @throws Exception
     */
    public static void createFaceDb(com.aliyun.facebody20191230.Client client, String dbName) throws Exception {
        try {
            CreateFaceDbRequest requestBody = new CreateFaceDbRequest()
                    .setName(dbName);
            client.createFaceDb(requestBody);
            com.aliyun.teaconsole.Client.log("--------------------创建人脸数据库成功--------------------");
        } catch (TeaException err) {
            com.aliyun.teaconsole.Client.log("create facebody db error");
            com.aliyun.teaconsole.Client.log(err.message);
        } catch (Exception _err) {
            TeaException err = new TeaException(_err.getMessage(), _err);
            com.aliyun.teaconsole.Client.log("create facebody db error");
            com.aliyun.teaconsole.Client.log(err.message);
        }
    }

    /**
     * 添加人脸样本
     * @param dbName 数据库名称
     * @param entityId 实体ID
     * @return void
     * @throws Exception
     */
    public static void addFaceEntity(com.aliyun.facebody20191230.Client client, String dbName, String entityId) throws Exception {
        try {
            AddFaceEntityRequest requestBody = new AddFaceEntityRequest();
            requestBody.dbName = dbName;
            requestBody.entityId = entityId;
            client.addFaceEntity(requestBody);
            com.aliyun.teaconsole.Client.log("--------------------创建人脸样本成功--------------------");
        } catch (TeaException err) {
            com.aliyun.teaconsole.Client.log("add face entity error.");
            com.aliyun.teaconsole.Client.log(err.message);
        } catch (Exception _err) {
            TeaException err = new TeaException(_err.getMessage(), _err);
            com.aliyun.teaconsole.Client.log("add face entity error.");
            com.aliyun.teaconsole.Client.log(err.message);
        }
    }

    /**
     * 添加人脸数据
     * @param dbName 数据库名称
     * @param entityId 实体ID
     * @param imageUrl 人脸图片地址，必须是同Region的OSS的图片地址。人脸必须是正面无遮挡单人人脸。
     * @return void
     * @throws Exception
     */
    public static void addFace(com.aliyun.facebody20191230.Client client, String dbName, String entityId, String imageUrl) throws Exception {
        try {
            AddFaceRequest requestBody = new AddFaceRequest();
            requestBody.dbName = dbName;
            requestBody.entityId = entityId;
            requestBody.imageUrl = imageUrl;
            client.addFace(requestBody);
            com.aliyun.teaconsole.Client.log("--------------------创建人脸数据成功--------------------");
        } catch (TeaException err) {
            com.aliyun.teaconsole.Client.log("add face error.");
            com.aliyun.teaconsole.Client.log(err.message);
        } catch (Exception _err) {
            TeaException err = new TeaException(_err.getMessage(), _err);
            com.aliyun.teaconsole.Client.log("add face error.");
            com.aliyun.teaconsole.Client.log(err.message);
        }
    }

    /**
     * 搜索人脸
     * @param dbName 数据库名称
     * @param imageUrl 图片URL地址。必须是同Region的OSS地址
     * @param limit 搜索结果数量限制
     * @return Facebody.SearchFaceResponse
     * @throws Exception
     */
    public static SearchFaceResponse searchFace(com.aliyun.facebody20191230.Client client, String dbName, String imageUrl, Integer limit) throws Exception {
        try {
            SearchFaceRequest requestBody = new SearchFaceRequest();
            requestBody.dbName = dbName;
            requestBody.imageUrl = imageUrl;
            requestBody.limit = limit;
            return client.searchFace(requestBody);
        } catch (TeaException err) {
            com.aliyun.teaconsole.Client.log("search face error.");
            com.aliyun.teaconsole.Client.log(err.message);
        } catch (Exception _err) {
            TeaException err = new TeaException(_err.getMessage(), _err);
            com.aliyun.teaconsole.Client.log("search face error.");
            com.aliyun.teaconsole.Client.log(err.message);
        }
        return null;
    }

    /**
     * 人脸比对 1:1
     * @param imageUrlA 待比对图片A的URL地址。必须是同Region的OSS地址
     * @param imageUrlB 待比对图片B的URL地址。必须是同Region的OSS地址
     * @return Facebody.SearchFaceResponseData
     * @throws Exception
     */
    public static CompareFaceResponse compareFace(com.aliyun.facebody20191230.Client client, String imageUrlA, String imageUrlB) throws Exception {
        try {
            CompareFaceRequest requestBody = new CompareFaceRequest();
            requestBody.imageURLA = imageUrlA;
            requestBody.imageURLB = imageUrlB;
            return client.compareFace(requestBody);
        } catch (TeaException err) {
            com.aliyun.teaconsole.Client.log("compare face error.");
            com.aliyun.teaconsole.Client.log(err.message);
        } catch (Exception _err) {
            TeaException err = new TeaException(_err.getMessage(), _err);
            com.aliyun.teaconsole.Client.log("compare face error.");
            com.aliyun.teaconsole.Client.log(err.message);
        }
        return null;
    }

    public static void main(String[] args_) throws Exception {
        java.util.List<String> args = java.util.Arrays.asList(args_);
        String regionId = args.get(0);
        String dbName = args.get(1);
        String entityId = args.get(2);
        java.util.List<String> faceUrlArr = com.aliyun.darabonbastring.Client.split(args.get(1), ",", 10);
        String testImgUrl = args.get(2);
        String testCompareImgUrl = args.get(3);
        // 获取人脸数据库Client
        com.aliyun.facebody20191230.Client client = Sample.createClient(regionId);
        // 创建人脸数据库
        Sample.createFaceDb(client, dbName);
        // 创建人脸样本
        Sample.addFaceEntity(client, dbName, entityId);
        // 为人脸样本添加图片
        for (String url : faceUrlArr) {
            Sample.addFace(client, dbName, entityId, url);
        }
        // 用测试图片去人脸数据库中查找
        SearchFaceResponse searchFaceResponse = Sample.searchFace(client, dbName, testImgUrl, 10);
        com.aliyun.teaconsole.Client.log(com.aliyun.teautil.Common.toJSONString(TeaModel.buildMap(searchFaceResponse)));
        // 测试 1:1 人脸比对
        CompareFaceResponse compareFaceResponse = Sample.compareFace(client, testImgUrl, testCompareImgUrl);
        com.aliyun.teaconsole.Client.log(com.aliyun.teautil.Common.toJSONString(TeaModel.buildMap(compareFaceResponse)));
    }
}
