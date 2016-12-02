package com.wallpaper.bingfotor.model;

import java.util.List;

/**
 * Created by Limuyang on 2016/12/2.
 */

public class Bean {

    /**
     * images : [{"startdate":"20161201","fullstartdate":"201612011600","enddate":"20161202","url":"http://s.cn.bing.net/az/hprichbg/rb/ResurrectionBay_ZH-CN10718475653_1920x1080.jpg","urlbase":"/az/hprichbg/rb/ResurrectionBay_ZH-CN10718475653","copyright":"在基奈峡湾国家公园的复活湾，阿拉斯加州，美国 (© Ron Niebrugge/Alamy)","copyrightlink":"http://www.bing.com/search?q=%E5%9F%BA%E5%A5%88%E5%B3%A1%E6%B9%BE%E5%9B%BD%E5%AE%B6%E5%85%AC%E5%9B%AD&form=hpcapt&mkt=zh-cn","wp":true,"hsh":"a41c0a0ea3c90195c70244d77f9e2edd","drk":1,"top":1,"bot":1,"hs":[]},{"startdate":"20161130","fullstartdate":"201611301600","enddate":"20161201","url":"http://s.cn.bing.net/az/hprichbg/rb/CiervaCove_ZH-CN10404920946_1920x1080.jpg","urlbase":"/az/hprichbg/rb/CiervaCove_ZH-CN10404920946","copyright":"南极半岛的西尔瓦湾 (© Aurora Photos/Offset)","copyrightlink":"http://www.bing.com/search?q=%E5%8D%97%E6%9E%81%E5%8D%8A%E5%B2%9B&form=hpcapt&mkt=zh-cn","wp":true,"hsh":"cbbfb904c0e1eef57f0059328dfad1fd","drk":1,"top":1,"bot":1,"hs":[]},{"startdate":"20161129","fullstartdate":"201611291600","enddate":"20161130","url":"http://s.cn.bing.net/az/hprichbg/rb/CattleEgrets_ZH-CN8513428115_1920x1080.jpg","urlbase":"/az/hprichbg/rb/CattleEgrets_ZH-CN8513428115","copyright":"两只牛背鹭站在布契尔斑马背上，利特弗雷自然保护区，南非 (© Richard Du Toit/Minden Pictures)","copyrightlink":"http://www.bing.com/search?q=Rietvlei+Nature+Reserve&form=hpcapt&mkt=zh-cn","wp":true,"hsh":"36597ab905f85653a5beac78cceaad2c","drk":1,"top":1,"bot":1,"hs":[]},{"startdate":"20161128","fullstartdate":"201611281600","enddate":"20161129","url":"http://s.cn.bing.net/az/hprichbg/rb/GrizzlyPeakSFVideo_ZH-CN11282703590_1920x1080.jpg","urlbase":"/az/hprichbg/rb/GrizzlyPeakSFVideo_ZH-CN11282703590","copyright":"旧金山-奥克兰海湾大桥和其背后的旧金山，加利福尼亚州 (© Engel Ching/Alamy)","copyrightlink":"http://www.bing.com/search?q=%E6%97%A7%E9%87%91%E5%B1%B1-%E5%A5%A5%E5%85%8B%E5%85%B0%E6%B5%B7%E6%B9%BE%E5%A4%A7%E6%A1%A5&form=hpcapt&mkt=zh-cn","wp":false,"hsh":"c5c30d089db44b596237b42b2fa03557","drk":1,"top":1,"bot":1,"hs":[]},{"startdate":"20161127","fullstartdate":"201611271600","enddate":"20161128","url":"http://s.cn.bing.net/az/hprichbg/rb/LondonRadiometers_ZH-CN12114654989_1920x1080.jpg","urlbase":"/az/hprichbg/rb/LondonRadiometers_ZH-CN12114654989","copyright":"英国皇家学会总部展示的古董放射计，伦敦，英国 (© Peter Macdiarmid/Staff/Getty Images)","copyrightlink":"http://www.bing.com/search?q=%E8%8B%B1%E5%9B%BD%E7%9A%87%E5%AE%B6%E5%AD%A6%E4%BC%9A&form=hpcapt&mkt=zh-cn","wp":false,"hsh":"fa76bb6d2694523946103a22f2c30f85","drk":1,"top":1,"bot":1,"hs":[]},{"startdate":"20161126","fullstartdate":"201611261600","enddate":"20161127","url":"http://s.cn.bing.net/az/hprichbg/rb/VictoriaTower_ZH-CN13097406171_1920x1080.jpg","urlbase":"/az/hprichbg/rb/VictoriaTower_ZH-CN13097406171","copyright":"维多利亚海滩边的灯塔，拉古纳海滩，加利福尼亚州 (© Jon Bilous/Shutterstock)","copyrightlink":"http://www.bing.com/search?q=Pirate+tower+at+Victoria+Beach&form=hpcapt&mkt=zh-cn","wp":true,"hsh":"713389dcff0cdd9409fae7defae59ee6","drk":1,"top":1,"bot":1,"hs":[]},{"startdate":"20161125","fullstartdate":"201611251600","enddate":"20161126","url":"http://s.cn.bing.net/az/hprichbg/rb/ThailandWaterfall_ZH-CN7044305410_1920x1080.jpg","urlbase":"/az/hprichbg/rb/ThailandWaterfall_ZH-CN7044305410","copyright":"爱侣湾国家公园，北碧府，泰国 (© Banana Republic Images/Shutterstock)","copyrightlink":"http://www.bing.com/search?q=%E7%88%B1%E4%BE%A3%E6%B9%BE%E5%9B%BD%E5%AE%B6%E5%85%AC%E5%9B%AD&form=hpcapt&mkt=zh-cn","wp":false,"hsh":"2dd107e235fa2c33f10f1bcc809d91d1","drk":1,"top":1,"bot":1,"hs":[]},{"startdate":"20161124","fullstartdate":"201611241600","enddate":"20161125","url":"http://s.cn.bing.net/az/hprichbg/rb/RissaTridactyla_ZH-CN9552683179_1920x1080.jpg","urlbase":"/az/hprichbg/rb/RissaTridactyla_ZH-CN9552683179","copyright":"悬崖上的三趾鸥巢穴，爱尔兰 (© Michel Gunther/Biosphoto/Minden Pictures)","copyrightlink":"http://www.bing.com/search?q=%E4%B8%89%E8%B6%BE%E9%B8%A5&form=hpcapt&mkt=zh-cn","wp":true,"hsh":"823c223a1f9fcc126c77a9b8246aa350","drk":1,"top":1,"bot":1,"hs":[]}]
     * tooltips : {"loading":"正在加载...","previous":"上一个图像","next":"下一个图像","walle":"此图片不能下载用作壁纸。","walls":"下载今日美图。仅限用作桌面壁纸。"}
     */

    private TooltipsBean tooltips;
    private List<ImagesBean> images;

    public TooltipsBean getTooltips() {
        return tooltips;
    }

    public void setTooltips(TooltipsBean tooltips) {
        this.tooltips = tooltips;
    }

    public List<ImagesBean> getImages() {
        return images;
    }

    public void setImages(List<ImagesBean> images) {
        this.images = images;
    }

    public static class TooltipsBean {
        /**
         * loading : 正在加载...
         * previous : 上一个图像
         * next : 下一个图像
         * walle : 此图片不能下载用作壁纸。
         * walls : 下载今日美图。仅限用作桌面壁纸。
         */

        private String loading;
        private String previous;
        private String next;
        private String walle;
        private String walls;

        public String getLoading() {
            return loading;
        }

        public void setLoading(String loading) {
            this.loading = loading;
        }

        public String getPrevious() {
            return previous;
        }

        public void setPrevious(String previous) {
            this.previous = previous;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }

        public String getWalle() {
            return walle;
        }

        public void setWalle(String walle) {
            this.walle = walle;
        }

        public String getWalls() {
            return walls;
        }

        public void setWalls(String walls) {
            this.walls = walls;
        }
    }

    public static class ImagesBean {
        /**
         * startdate : 20161201
         * fullstartdate : 201612011600
         * enddate : 20161202
         * url : http://s.cn.bing.net/az/hprichbg/rb/ResurrectionBay_ZH-CN10718475653_1920x1080.jpg
         * urlbase : /az/hprichbg/rb/ResurrectionBay_ZH-CN10718475653
         * copyright : 在基奈峡湾国家公园的复活湾，阿拉斯加州，美国 (© Ron Niebrugge/Alamy)
         * copyrightlink : http://www.bing.com/search?q=%E5%9F%BA%E5%A5%88%E5%B3%A1%E6%B9%BE%E5%9B%BD%E5%AE%B6%E5%85%AC%E5%9B%AD&form=hpcapt&mkt=zh-cn
         * wp : true
         * hsh : a41c0a0ea3c90195c70244d77f9e2edd
         * drk : 1
         * top : 1
         * bot : 1
         * hs : []
         */

        private String startdate;
        private String fullstartdate;
        private String enddate;
        private String url;
        private String urlbase;
        private String copyright;
        private String copyrightlink;
        private boolean wp;
        private String hsh;
        private int drk;
        private int top;
        private int bot;
        private List<?> hs;

        public String getStartdate() {
            return startdate;
        }

        public void setStartdate(String startdate) {
            this.startdate = startdate;
        }

        public String getFullstartdate() {
            return fullstartdate;
        }

        public void setFullstartdate(String fullstartdate) {
            this.fullstartdate = fullstartdate;
        }

        public String getEnddate() {
            return enddate;
        }

        public void setEnddate(String enddate) {
            this.enddate = enddate;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrlbase() {
            return urlbase;
        }

        public void setUrlbase(String urlbase) {
            this.urlbase = urlbase;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public String getCopyrightlink() {
            return copyrightlink;
        }

        public void setCopyrightlink(String copyrightlink) {
            this.copyrightlink = copyrightlink;
        }

        public boolean isWp() {
            return wp;
        }

        public void setWp(boolean wp) {
            this.wp = wp;
        }

        public String getHsh() {
            return hsh;
        }

        public void setHsh(String hsh) {
            this.hsh = hsh;
        }

        public int getDrk() {
            return drk;
        }

        public void setDrk(int drk) {
            this.drk = drk;
        }

        public int getTop() {
            return top;
        }

        public void setTop(int top) {
            this.top = top;
        }

        public int getBot() {
            return bot;
        }

        public void setBot(int bot) {
            this.bot = bot;
        }

        public List<?> getHs() {
            return hs;
        }

        public void setHs(List<?> hs) {
            this.hs = hs;
        }
    }
}
