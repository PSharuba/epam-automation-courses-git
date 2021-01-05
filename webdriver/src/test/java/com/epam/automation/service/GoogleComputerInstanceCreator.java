package com.epam.automation.service;

import com.epam.automation.model.GoogleCloudComputerInstance;

public class GoogleComputerInstanceCreator {
    private static final String DEFAULT_PREFIX = "google.cloud";
    private static final String INSTANCE_INSTANCE_NUMBER_POSTFIX = "instance.number";
    private static final String INSTANCE_SYSTEM_POSTFIX = "system";
    private static final String INSTANCE_VM_CLASS_POSTFIX = "vmClass";
    private static final String INSTANCE_INSTANCE_SERIES_POSTFIX = "instance.series";
    private static final String INSTANCE_INSTANCE_TYPE_POSTFIX = "instance.type";
    private static final String INSTANCE_GPU_COUNT_POSTFIX = "gpu.count";
    private static final String INSTANCE_GPU_TYPE_POSTFIX = "gpu.type";
    private static final String INSTANCE_SSD_TYPE_POSTFIX = "ssd";
    private static final String INSTANCE_DATACENTER_POSTFIX = "datacenter";
    private static final String INSTANCE_COMMITED_USAGE_POSTFIX = "usage";
    private static final String INSTANCE_EXPECTED_PRICE_POSTFIX = "price";

    public static GoogleCloudComputerInstance createNewPasteFromProperties() {
        DataReader reader = new DataReader(DEFAULT_PREFIX);

        int instanceCount = Integer.parseInt(reader.readDataWithPrefix(INSTANCE_INSTANCE_NUMBER_POSTFIX));
        String system = reader.readDataWithPrefix(INSTANCE_SYSTEM_POSTFIX);
        String vmClass = reader.readDataWithPrefix(INSTANCE_VM_CLASS_POSTFIX);
        String series = reader.readDataWithPrefix(INSTANCE_INSTANCE_SERIES_POSTFIX);
        String type = reader.readDataWithPrefix(INSTANCE_INSTANCE_TYPE_POSTFIX);
        int gpuCount = Integer.parseInt(reader.readDataWithPrefix(INSTANCE_GPU_COUNT_POSTFIX));
        String gpuType = reader.readDataWithPrefix(INSTANCE_GPU_TYPE_POSTFIX);
        String ssdType = reader.readDataWithPrefix(INSTANCE_SSD_TYPE_POSTFIX);
        String datacenter = reader.readDataWithPrefix(INSTANCE_DATACENTER_POSTFIX);
        String usage = reader.readDataWithPrefix(INSTANCE_COMMITED_USAGE_POSTFIX);
        String expectedPrice = reader.readDataWithPrefix(INSTANCE_EXPECTED_PRICE_POSTFIX);

        return new GoogleCloudComputerInstance(instanceCount, system, vmClass, series,
                type, gpuCount, gpuType, ssdType,
                datacenter, usage, expectedPrice);
    }
}
