package com.lewis.compare;

import com.alibaba.fastjson.JSON;
import com.lewis.compare.vo.Boss3ResRelationVo;
import com.lewis.compare.vo.Envirnment;
import com.lewis.compare.vo.ServiceParam;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by zhangminghua on 2016/6/14.
 */
public class InvokerClient {

    public String  invokeService(ServiceParam serviceParam,SplitTime splitTime){
        MethodEnum methodEnum = serviceParam.getMethodEnum();
        try {
            if (methodEnum != null) {
                CloseableHttpClient httpClient = HttpClients.createDefault();
                String url = "";
                if (splitTime == SplitTime.SPLIT_BEFORE) {
                    url = serviceParam.getUrlSplitBefore();
                }else{
                    url = serviceParam.getUrlSplitAfter();
                }
                if (methodEnum == MethodEnum.GET) {
                    String entityString = doExecuteGet(serviceParam, httpClient, url);
                    System.out.println(entityString);
                    return entityString;
                }else{
                    String entityString = doExecutePost(serviceParam, httpClient, url);
                    System.out.println(entityString);
                    return entityString;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String doExecutePost(ServiceParam serviceParam, CloseableHttpClient httpClient, String url) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        String inputParams = serviceParam.getInputParams();
        System.out.println("params is "+inputParams);
        httpPost.setEntity(new StringEntity(Base64Util.encode(inputParams)));
        CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity entity = httpResponse.getEntity();
        String entityString = EntityUtils.toString(entity);
        entityString = Base64Util.decode(entityString);
        return entityString;
    }

    private String doExecuteGet(ServiceParam serviceParam, CloseableHttpClient httpClient, String url) throws IOException {
        String inputParams = serviceParam.getInputParams();
        url= url +"?"+ Base64Util.encode(inputParams);
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity entity = httpResponse.getEntity();
        String entityString = EntityUtils.toString(entity);
        entityString = Base64Util.decode(entityString);
        return entityString;
    }

    public boolean compareEquals(ServiceParam serviceParam){
        String splitBeforeResult = invokeService(serviceParam, SplitTime.SPLIT_BEFORE);
        String splitAfterResult = invokeService(serviceParam, SplitTime.SPLIT_AFTER);
        boolean isEquals = splitAfterResult.equals(splitBeforeResult);
        //若比较拆分前 和 拆分后的返回结果不一致，则将入参写到文件中
        if (!isEquals) {
            FileWriterUtils.write(serviceParam);
        }
        return isEquals;
    }

    public static void main(String[] args) {
        InvokerClient client = new InvokerClient();
/*        ServiceParam serviceParam = new ServiceParam();
        serviceParam.setEnv(Envirnment.STABLE);
        serviceParam.setContextPath("/product/detail");
        serviceParam.setMethodEnum(MethodEnum.GET);
        serviceParam.setServiceName("BOH.NM.ProductController.getDetail");
        ProductDetailRequestVo param = new ProductDetailRequestVo();
        param.setProductId(210186614);
        param.setProductType(1);
        serviceParam.setInputParams(JSON.toJSONString(param));
        InvokerClient client = new InvokerClient();
        boolean IsEquals = client.compareEquals(serviceParam);
        System.out.println("isEquals="+IsEquals);*/
        Boss3ResRelationVo resRelationVo = new Boss3ResRelationVo();
        resRelationVo.setLimit(10);
        resRelationVo.setStart(0);
        resRelationVo.setResId(Arrays.asList(1515359365));
        resRelationVo.setResType(27);
        ServiceParam serviceParam = new ServiceParam();
        serviceParam.setEnv(Envirnment.STABLE);
        serviceParam.setContextPath("/resource/resource-relation");
        serviceParam.setMethodEnum(MethodEnum.POST);
        serviceParam.setServiceName("BOH.NM.NgResourceController.queryResourceRelation");
        serviceParam.setInputParams(JSON.toJSONString(resRelationVo));
        boolean isTrue = client.compareEquals(serviceParam);
        System.out.println(isTrue);
        FileWriterUtils.write(serviceParam);
    }
}
