public class UnionFind {

    /**
     * vertex[idx] - the parent of the vertex i
     * size[idx] - degree of the idx vertex(not his parent)
     */
    int[] vertex;
    int[] size;

    /**
     * construct the union find arrays
     * @param verAmount - amount of vertix to this object
     */
    public UnionFind (int verAmount){
        this.vertex = new int[verAmount];
        // initialize ea vertex to be his own parent
        for (int i=0; i < verAmount; i++){
            this.vertex[i] = i;
        }
        this.size = new int[verAmount];
    }

    /**
     * use path compression, O(log*(n))
     * @param ver
     * @return
     */
    int find(int ver){
        if (this.vertex[ver] != ver){
            this.vertex[ver] = find(this.vertex[ver]);
        }
        return this.vertex[ver];
    }

    /**
     * using Union by Weight
     * @param ver1 - vertex idx
     * @param ver2 - vertex idx
     * return boolean - TRUE for unioned, FALSE for no need to union(same parents already)
     */
    boolean union(int ver1, int ver2){
        boolean ans = false;
        ver1 = this.find(ver1);
        ver2 = this.find(ver2);

        if (this.size[ver1] >= this.size[ver2]){
            this.vertex[ver2] = ver1;
            this.size[ver1] += this.size[ver2];
            ans = true;
        }
        else if (this.size[ver1] < this.size[ver2]){
            this.vertex[ver1] = ver2;
            this.size[ver2] += this.size[ver1];
            ans = true;
        }
        return ans;
    }

    /**
     *
     * @param ver1 vertex idx
     * @param ver2 vertex idx
     * @return true if the vertexes doesnt share same parent
     */
    boolean disJointGroups(int ver1, int ver2){
        return find(ver1) != find(ver2);
    }

}
