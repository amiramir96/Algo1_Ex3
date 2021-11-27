import java.util.ArrayList;
import java.util.List;

public class UnionFind {

    /**
     * its a pure unionFind algorithm! using path compression and union by weight!
     * the other files only using this algorithm, but the algo can be used for
     * any other use of union find that relay on integers represantion (all is needed is isomorphic linear tansformation)
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
     * @return root of the tree of vertex ver
     */
    public int find(int ver){
        // use dynamic programming in place of recursion
        // use list to save whole chain of parents of ver till the root tree
        List dynamicFindList = new ArrayList<Integer>();
        // ensure that if ver is himself root - no compile prob
        dynamicFindList.add(ver);

        if (ver != this.vertex[ver]){ // else - we cane just return ver as root
            do { // save the first iterate since while and if questions is the same
                ver = this.vertex[ver];
                dynamicFindList.add(ver);
            } while (this.vertex[ver] != ver);
            // edit the found root to be parent of all the chain of vertex along the tree that we saved
            for (Object vTemp : dynamicFindList){
                this.vertex[(Integer)vTemp] = ver;
            }
        }
        return ver;
    }

    /**
     * using Union by Weight
     * @param ver1 - vertex idx
     * @param ver2 - vertex idx
     * return boolean - TRUE for unioned, FALSE for no need to union(same parents already)
     */
    public void union(int ver1, int ver2){
        // get parents of v1 v2
        ver1 = this.find(ver1);
        ver2 = this.find(ver2);
        if (ver1 == ver2){
            return;
        }
        // union the small to the big
        if (this.size[ver1] >= this.size[ver2]){
            this.vertex[ver2] = ver1;
            this.size[ver1] += this.size[ver2];
        }
        else {
            this.vertex[ver1] = ver2;
            this.size[ver2] += this.size[ver1];
        }
    }

    /**
     * @param ver1 vertex idx
     * @param ver2 vertex idx
     * @return true if the vertexes doesnt share same parent
     */
    public boolean disJointGroups(int ver1, int ver2){
        return find(ver1) != find(ver2);
    }

}
