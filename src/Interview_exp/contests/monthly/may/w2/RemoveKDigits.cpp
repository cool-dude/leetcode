class Solution {
public:
    void insertInNonDecOrder(deque<char> &dq, char ch)
    {
	    if (dq.empty())
		    dq.push_back(ch);
	    else{
		    char temp = dq.back();
            while( temp > ch && !dq.empty()){
			    dq.pop_back();
			    if (!dq.empty())
				    temp = dq.back();
		    }
		    dq.push_back(ch);
	    }
	    return;
    }
    string removeKdigits(string str, int k) {
        int len = str.length();
	    int n = len - k;
        if(n==0) return "0";
	    deque<char> dq;
	    string res = "";
	    int i;
	    for (i=0; i<=len-k; i++)
		    insertInNonDecOrder(dq, str[i]);

	    while (i < len){
		    res += dq.front();
    	    dq.pop_front();
    	    insertInNonDecOrder(dq, str[i]);
		    i++;
	    }
	    res += dq.front();
	    dq.pop_front();
        while(res[0]=='0' && res.length()>1)
            res.erase(0,1);
	    return res;
    }
};