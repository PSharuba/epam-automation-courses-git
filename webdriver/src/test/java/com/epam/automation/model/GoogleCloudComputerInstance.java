package com.epam.automation.model;

import java.util.Objects;

public class GoogleCloudComputerInstance {
    private int instanceCount;
    private String system;
    private String vmClass;
    private String series;
    private String type;
    private int gpuCount;
    private String gpuType;
    private String ssdType;
    private String datacenter;
    private String usage;
    private String expectedPrice;

    public GoogleCloudComputerInstance(int instanceCount, String system, String vmClass, String series,
                                       String type, int gpuCount, String gpuType, String ssdType,
                                       String datacenter, String usage, String expectedPrice) {
        this.instanceCount = instanceCount;
        this.system = system;
        this.vmClass = vmClass;
        this.series = series;
        this.type = type;
        this.gpuCount = gpuCount;
        this.gpuType = gpuType;
        this.ssdType = ssdType;
        this.datacenter = datacenter;
        this.usage = usage;
        this.expectedPrice = expectedPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoogleCloudComputerInstance that = (GoogleCloudComputerInstance) o;
        return instanceCount == that.instanceCount &&
                gpuCount == that.gpuCount &&
                Objects.equals(system, that.system) &&
                Objects.equals(vmClass, that.vmClass) &&
                Objects.equals(series, that.series) &&
                Objects.equals(type, that.type) &&
                gpuType.equals(that.gpuType) &&
                ssdType.equals(that.ssdType) &&
                Objects.equals(datacenter, that.datacenter) &&
                Objects.equals(usage, that.usage) &&
                Objects.equals(expectedPrice, that.expectedPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instanceCount, system, vmClass, series, type, gpuCount, gpuType, ssdType, datacenter, usage, expectedPrice);
    }

    @Override
    public String toString() {
        return "GoogleCloudComputerInstance{" +
                "instanceCount=" + instanceCount +
                ", system='" + system + '\'' +
                ", vmClass='" + vmClass + '\'' +
                ", series='" + series + '\'' +
                ", type='" + type + '\'' +
                ", gpuCount=" + gpuCount +
                ", gpuType='" + gpuType + '\'' +
                ", ssdType='" + ssdType + '\'' +
                ", datacenter='" + datacenter + '\'' +
                ", usage='" + usage + '\'' +
                ", expectedPrice='" + expectedPrice + '\'' +
                '}';
    }

    public int getInstanceCount() {
        return instanceCount;
    }

    public void setInstanceCount(int instanceCount) {
        this.instanceCount = instanceCount;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getVmClass() {
        return vmClass;
    }

    public void setVmClass(String vmClass) {
        this.vmClass = vmClass;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getGpuCount() {
        return gpuCount;
    }

    public void setGpuCount(int gpuCount) {
        this.gpuCount = gpuCount;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getSsdType() {
        return ssdType;
    }

    public void setSsdType(String ssdType) {
        this.ssdType = ssdType;
    }

    public String getDatacenter() {
        return datacenter;
    }

    public void setDatacenter(String datacenter) {
        this.datacenter = datacenter;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public String getExpectedPrice() {
        return expectedPrice;
    }

    public void setExpectedPrice(String expectedPrice) {
        this.expectedPrice = expectedPrice;
    }
}
