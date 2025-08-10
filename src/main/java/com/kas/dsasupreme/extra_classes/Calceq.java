package com.kas.dsasupreme.extra_classes;

import java.util.List;

class CalcDiv_DFS {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        double[] res = new double[queries.size()];
        //step 1: build Graph
        //[a,b],[b,c],[a,c] [3,0.5,1.5]
        //make a -> b,3
        //s.t b->a ,1/3
        HashMap<String,HashMap<String,Double>> adjList = new HashMap<>();
        for(int i=0;i<equations.size();i++){
            List<String> eq = equations.get(i);
            String key = eq.get(0); //dividend
            String valS = eq.get(1); //divisor
            double valD = values[i]; //quotient

            //if key not in list then insert blank map entry
            if(!adjList.containsKey(key))
                adjList.put(key,new HashMap<String,Double>());
            
            //to make bidirectional
            if(!adjList.containsKey(valS))
                adjList.put(valS,new HashMap<String,Double>());

            adjList.get(key).put(valS,valD);
            adjList.get(valS).put(key,1/valD);
        
        }
            //Step2 evaluate Query by DFD
            //if agraph contains path src(dividend) to dest(divisor)
            for(int j=0;j<queries.size();j++){
                List<String> pair = queries.get(j);

                String src = pair.get(0);
                String dest = pair.get(1);
                //if no path available , src or dest not in adjList
                if(!adjList.containsKey(src) || !adjList.containsKey(dest)){
                    res[j] = -1;
                }
                else if(src == dest)//src = dest
                {
                    res[j] = 1;
                }
                else{//apply dfs to find path between src(dividend) and dest(divisor)
                    Set<String> visited = new HashSet<String>();
                    
                    int accProd =1;
                    res[j] = searchPath(adjList, src, dest, visited,accProd);
                }


            }
            

    return res;
    }
    public double searchPath(HashMap<String,HashMap<String,Double>> adjList,String src,String dest,Set<String> visited,double accProd){
        double ret =-1;
        visited.add(src);
        Map<String,Double> neighbours = adjList.get(src);
         if(neighbours.containsKey(dest)){
            ret = accProd * neighbours.get(dest);
            System.out.println("k "+ ret);
         }
        else{
         for(Map.Entry<String,Double> entry:neighbours.entrySet()){
             String nbrNode = entry.getKey();
             if(visited.contains(nbrNode))
                continue; //skip
                
                //or else call dfs
                System.out.println("entry.getKey() "+ entry.getKey());
                ret = searchPath(adjList,nbrNode,dest,visited,accProd * entry.getValue());
                System.out.println(" "+ ret);
                if(ret != -1)// -1 means not yet found
                    break;
             }
         }


         //unmark visit, for nex iteration
         visited.remove(src);
         return ret;
    }
}
