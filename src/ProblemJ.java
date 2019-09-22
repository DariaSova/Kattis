import java.io.*;
/*Progressive Scramble problem*/
public class ProblemJ{
    public static void main(String[] args)throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int numPuts = Integer.parseInt(input.readLine());
        
        for (int i = 0;i<numPuts;i++){
            String line = input.readLine();
            //char[] cmd = line.toCharArray();
            int[] keys = new int[line.length()-2];
            if (line.charAt(0)=='e'){
                for (int j=2;j<line.length();j++){
                    int temp;
                    if (line.charAt(j)==' '){
                        keys[j-2] = keys[j-3];
                    }else{
                        temp = (int)line.charAt(j);
                        //System.out.println(temp-96);
                        if (j>2){
                            keys[j-2] = (temp-96)+keys[j-3];
                        }else{
                            keys[0] = (temp-96);
                        }
                    }
                    //System.out.print(keys[j-2]+" ");
                }
                String output = "";
                for (int j = 0; j<keys.length;j++){
                    if (keys[j]%27==0){
                        output+=" ";
                    }else{
                        keys[j] = keys[j]%27;
                        int val = keys[j]+96;
                        output += String.valueOf((char)val);
                    }
                    }
                System.out.println(output);
                
            /*  for (int j=0;j<keys.length;j++){
                    System.out.print(keys[j]+" ");
                }*/
            }else{
                int k = 27;
                String output = "";
                for (int j=2; j<line.length();j++){
                    if (j==2){
                        keys[j-2] = ((int)line.charAt(j))-96;
                    }else if ((int)line.charAt(j)>0){
                        keys[j-2] = (int)((line.charAt(j)-96)+k);
                    }else{
                        keys[j-2] = k*2;
                        
                    }
                    k+=27;
                    
                }
                for (int j =keys.length-1;j>0;j--){
                    keys[j] = keys[j] - keys[j-1];  
                }
                for (int j = 0;j<keys.length;j++){
                    output+=String.valueOf((char)(keys[j]+96));
                }
                System.out.println(output); 
            }
            
        }
    }
}

