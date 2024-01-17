package com.zs.backend.utils;


/**
 * 雪花算法生成id
 */
public class IcbcSerialNoUtil {
    private final static SnowflakeIdGenerator generator;

    static {
        Long dataCenterId = Long.valueOf(RandomUtils.randomNum(16));
        Long workerId = Long.valueOf(RandomUtils.randomNum(16));

//        String dataCenterIdStr = System.getenv("data-center-id");
//        String workerIdStr = System.getenv("worker-id");
//        dataCenterId = Long.parseLong(dataCenterIdStr);
//        workerId = Long.parseLong(workerIdStr);
        generator = new SnowflakeIdGenerator(dataCenterId, workerId);
    }

    public static long getId() {
        return generator.nextId();
    }

    /**
     * 支付单号
     */
    public static String genPaymentNo() {
        return PAYMENT_NO_PREFIX + generator.nextId();
    }

    /**
     * 业务流水号
     */
    public static String genBusinessSerialNo() {
        return BUSINESS_SERIAL_NO_PREFIX + generator.nextId();
    }

    public static final String PAYMENT_NO_PREFIX = "P";
    public static final String BUSINESS_SERIAL_NO_PREFIX = "B";

}
