package jp.bizreach.twitter.app.web;

/**
 * @author mayuko.sakaba
 */
public class TweetDto {
    public String username;
    public String accountName;
    public String tweetTime;
    public String tweet;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
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
