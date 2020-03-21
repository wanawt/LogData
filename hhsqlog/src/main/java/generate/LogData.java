package generate;

import java.io.Serializable;

/**
 * log_data
 * @author 
 */
public class LogData implements Serializable {
    private String os;

    private String channel;

    private String createTime;

    private String deviceId;

    private String deviceUniqueId;

    private String environment;

    private String ip;

    private String topic;

    private String platform;

    private String module;

    private String userId;

    private String vendor;

    private String version;
    private String item;
    private String from;
    private String keyword;

    private String click_position;
    private String spot_id;
    private String page;

    private String item_id;     // 商品id
    private String shop_type;   // 商品商铺
    private String title;       // 商品标题

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getShop_type() {
        return shop_type;
    }

    public void setShop_type(String shop_type) {
        this.shop_type = shop_type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClick_position() {
        return click_position;
    }

    public String getSpot_id() {
        return spot_id;
    }

    public String getPage() {
        return page;
    }

    public void setClick_position(String click_position) {
        this.click_position = click_position;
    }

    public void setSpot_id(String spot_id) {
        this.spot_id = spot_id;
    }

    public void setPage(String page) {
        this.page = page;
    }

    private static final long serialVersionUID = 1L;

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceUniqueId() {
        return deviceUniqueId;
    }

    public void setDeviceUniqueId(String deviceUniqueId) {
        this.deviceUniqueId = deviceUniqueId;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

}