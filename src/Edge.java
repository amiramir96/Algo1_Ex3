public class Edge {

    int _from; //smaller id num
    int _to; // bigger id num
    boolean exist; //true means we gonna print this edge!
    UnionFind uf;

    public Edge(int v1, int v2, UnionFind something){
        this._from = v1;
        this._to = v2;
        this.exist = false;
        this.uf = something;
    }

    public Edge(int v1, int v2, boolean wall, UnionFind something){
        this._from = v1;
        this._to = v2;
        this.uf = something;
        this.setExistence(wall);
    }

    public boolean setExistence(boolean alpha){
        if (alpha){
            this.exist = true;
            return uf.union(this._from, this._to);
        }
        return false;
    }

    @Override
    public String toString(){
        return "from: "+this._from+" to: "+this._to+" exist?: "+this.exist+" parent: "+uf.find(_from);
    }
}
