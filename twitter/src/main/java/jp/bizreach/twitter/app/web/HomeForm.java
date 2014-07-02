package jp.bizreach.twitter.app.web;

import org.seasar.struts.annotation.Required;

public class HomeForm {
    @Required
    // ここにメッセージを入れることができる。詳しくは調べること。
    public String birthday;
    public Integer birthYear;
    public Integer birthMonth;
    public Integer birthDate;
    public String profile;
    public String inputTweet;
    public String searchWord;
}
