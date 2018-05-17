package com.huanxian.core.em;

public enum BasePropertyPropGroupEnum {

	SYSTEM("系统参数"), QCLOUDAV("腾讯视频互动直播"), SMS("短信"), IM("IM消息"), COS("腾讯对象存储服务")
	,SIG("腾讯直播签名"), JPUSH("极光推送");
	 private String label;
    private String ename;

    public String getEname() {
        return this.name();
    }

    private BasePropertyPropGroupEnum(String label) {

        this.label = label;
    }

    public static String getName(String label) {
        for (BasePropertyPropGroupEnum c : BasePropertyPropGroupEnum.values()) {
            if (c.label.equals(label)) {
                return c.name();
            }
        }
        return null;
    }

    // 覆盖方法
    @Override
    public String toString() {
        return this.label;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
