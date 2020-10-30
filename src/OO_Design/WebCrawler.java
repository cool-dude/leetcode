/*LC1242: Web Crawler Multithreaded
https://leetcode.com/problems/web-crawler-multithreaded/
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation*/
import java.util.*;
interface HTMLParser{
    public List<String> getUrls(String url){}
}
class Sln{
    ConcurrentHashMap<String,Integer> urls=new ConcurrentHashMap();
    String hostName;
    HTMLParser htmlParser;
    public List<Strig> crawl(final String startUrl, HTMLParser htmlParser_){
        int idx=startUrl.indexOf('/',7);
        hostName=(idx!=-1):startUrl.substring(0,idx):startUrl;
        htmlParser=htmlParser_;
        Thread t=new Thread(()->crawlUrl(startUrl));
        t.start();
        joinThread(t);
        return new ArrayList<>(urls.keySet());
    }
    void crawlUrl(final String startUrl){
        if(startUrl.startsWith(hostName) && !urls.containsKey(startUrl)){
            urls.put(startUrl,1);
            List<Thread> threads=new ArrayList<>();
            for(String url:htmlParser.getUrls(startUrl)){
                Thread t1=new Thread(()->crawlUrl(startUrl));
                threads.add(t1);
                t1.start();
            }
            for(Thread t:threads) joinThread(t);
        }
    }
    void joinThread(Thread t) {
        try{
            t.join();
        }
        catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
}