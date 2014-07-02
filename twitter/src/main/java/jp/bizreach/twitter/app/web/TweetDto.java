package jp.bizreach.twitter.app.web;


/**
 * @author mayuko.sakaba
 */
public class TweetDto {
    public String memberName;
    public String tweetTime;
    public String tweet;

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getTweetTime() {
        return tweetTime;
    }

    public void setTweetTime(String tweetTime) {
        this.tweetTime = tweetTime;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }
}
