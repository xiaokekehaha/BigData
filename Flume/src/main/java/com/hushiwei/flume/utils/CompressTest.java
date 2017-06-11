package com.hushiwei.flume.utils;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by HuShiwei on 2016/8/21 0021.
 */

/**
 * 压缩消息测试
 */
public class CompressTest {
    public static void main(String[] args) throws IOException {
        String message = "VID:16884,VIN:000000000000016863,TIME:20150803153334,TYPE:REALTIME,2210:0,2608:2,VTYPE:24,2609:73,2606:4040,2607:1,2002:1,2604:1,2003:MTo0MDQwXzQwNDBfNDA0MF80MDQwXzQwNDBfNDA0MF80MDQwXzQwNDBfNDA0MF80MDQwXzQwNDBfNDA2MF80MDYwXzQwNjBfNDA2MF80MDQwXzQwNjBfNDA0MF80MDQwXzQwNDBfNDA2MF80MDQwXzQwNDBfNDA0MF80MDYwXzQwNDBfNDA2MF80MDQwXzQwNDBfNDA0MF80MDQwXzQwNDBfNDA0MF80MDQwXzQwNDBfNDA0MF80MDQwXzQwNDBfNDA0MF80MDQwXzQwNDBfNDA0MF80MDYwXzQwNDBfNDA0MF80MDQwXzQwNjBfNDA2MF80MDYwXzQwNjBfNDA2MF80MDQwXzQwNDBfNDA2MF80MDYwXzQwNjBfNDA0MF80MDYwXzQwNjBfNDA2MF80MDYwXzQwNjBfNDA2MF80MDYwXzQwNjBfNDA2MF80MDQwXzQwNDBfNDA0MF80MDYwXzQwNDBfNDA0MF80MDQwXzQwNjBfNDA2MF80MDQwXzQwNDBfNDA2MF80MDQwXzQwNjBfNDA2MF80MDYwXzQwNjBfNDA2MF80MDYwXzQwNjBfNDA2MF80MDYwXzQwNDBfNDA2MF80MDQw,2605:1,2602:12,2603:4060,2601:1,2505:0,2209:100,2208:0,2103:MTo3MV83M183Ml83MV83Ml83MV83MV83MV83MV83MV83Ml83MV83MV83MF83MF83MF82OV83MF83MF83MA==,2101:20,2102:1,2504:0,2203:16,2503:39902797,2202:54280,2502:116290406,2201:0,2501:0,2801:0,2615:212,2616:258,2617:10000,2611:17,2612:69,2613:3690,2808:0,2614:9920,2802:0,2804:0,2610:1,2303:0,2304:83,2305:3680,2306:10002,2301:1,2302:16,2001:91,2000:20150803153334";

        byte[] b = CompressUtil.compress(message);

        System.out.println(message.getBytes().length);
        System.out.println(b.length);
        String uncompress = CompressUtil.uncompress(b);
        System.out.println(uncompress);

    }
}