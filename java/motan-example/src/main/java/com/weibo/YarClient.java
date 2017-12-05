/*
 *  Copyright 2009-2016 Weibo, Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.weibo;
import com.weibo.yar.yarclient.HttpYarClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class YarClient
{
    public static void main(String[] args) throws InterruptedException {
        HttpYarClient yarClient = new HttpYarClient();
        Map<String,String> reqParams = new HashMap<String, String>();
        reqParams.put("name","idevz");
        String result = null;
        String resultx = null;
        try {
            result = yarClient.call("http://10.211.55.2:8080/motan_yar/helloworld", "Hellox", String.class, "yar");
            System.out.println(result);

            resultx = yarClient.call("http://10.211.55.2:8080/motan_yar/helloworld", "Hello", String.class, reqParams);
            System.out.println(resultx);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
