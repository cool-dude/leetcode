class Solution {
public:
    int maxDiff(int num) {
        vector<int> res;
        for (int i = 0; i <= 9; ++i) {
            for (int k = 0; k <= 9; ++k) {
                string t = to_string(num);
                for (int j = (int) t.size() - 1; j >= 0; --j) {
                    if (t[j] - '0' == k) {
                        t[j] = '0' + i;
                    }
                }
                if (t[0] != '0') {
                    res.emplace_back(stoi(t));
                }
            }
        }
        sort(res.begin(), res.end());
        return res.back() - res.front();
    }
};