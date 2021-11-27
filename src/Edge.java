public class Edge {
    /**
     * this object represent edges between given two vertexes of the maze
     */
    int _from; //smaller id num
    int _to; // bigger id num
    boolean exist; //true means we gonna print this edge!
    UnionFind uf; // the union find obj of the maze

    /**
     * constructor, default settings - exist is false (till we decide otherwise)
     * @param v1 represent vertex from
     * @param v2 represent vertex to
     * @param mazeUF
     */
    public Edge(int v1, int v2, UnionFind mazeUF){
        this._from = v1;
        this._to = v2;
        this.exist = false;
        this.uf = mazeUF;
    }

    /**
     * simple setter for exist param
     * @param alpha - is boolean
     * @return - the existence parameter as been edited?
     */
    protected  boolean setExistence(boolean alpha){
        if (alpha){
            this.exist = true;
            uf.union(this._from, this._to);
            return true;
        }
        return false;
    }

    /**
     * we like strings!
     * @return printing toString
     */
    @Override
    public String toString(){
        return "from: "+this._from+" to: "+this._to+" exist?: "+this.exist+" parent: "+uf.find(_from);
    }
}
