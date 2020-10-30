class Nd{
    int d;
    Nd lft,rgt;
}

class Soln{
    Nd root;
    void prnLeaves(Nd nd){
        if(nd){
            prnLeaves(nd.lft);
            if(!nd.lft && !nd.rgt)
                print(nd.d+" ");
            prnLeaves(nd.rgt);
        }
    }

    void prnBndLft(Nd nd)}{
        if(nd){
            if(nd.lft){
                print(nd.d+" ");
                prnBndLft(nd.lft);
            }
            else if(nd.rgt){
                print(nd.d+" ");
                prnBndLft(nd.rgt);
            }
        }
    }

    void prnBndRgt(Nd nd)}{
        if(nd){
            if(nd.rgt){
                prnBndRgt(nd.rgt);
                print(nd.d+" ");
            }
            else if(nd.lft){
                prnBndRgt(nd.lft);
                print(nd.d+" ");
            }
        }
    }

    void prnBnd(Nd nd){
        if(nd){
            prn(nd.d+" ");
            prnBndLft(nd.lft);

            prnLeaves(nd.lft);
            prnLeaves(nd.rgt);
            prnBndRgt(nd.rgt);
        }
    }
}