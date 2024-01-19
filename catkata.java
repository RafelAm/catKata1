import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

public class PeacefulYardTest {
    @Test
    public void ExampleTests() {
      System.out.println("Only one cat is in the yard");
      assertEquals(true, PeacefulYard.peacefulYard(new String[] {"------------", "------------", "-L----------", "------------", "------------", "------------"}, 10));
      System.out.println("There are two cats in the yard, and they are closer than the minimum distance");
      assertEquals(false, PeacefulYard.peacefulYard(new String[] {"------------", "---M--------", "------------", "------------", "-------R----", "------------"}, 6));
      System.out.println("All three cats are in the yard, all further apart than or equal to the minimum distance");
      assertEquals(true, PeacefulYard.peacefulYard(new String[] {"-----------L", "--R---------", "------------", "------------", "------------", "--M---------"}, 4));
    }
}

public class PeacefulYard {
    public static boolean peacefulYard(String[] yard, int minDistance) {
      
      int[][] cats;
      cats = new int[3][2];
      int count = 0;
      
      for(int i = 0;i < yard.length;i++){
        for(int j = 0;j < yard[i].length(); j++){
          char ts = yard[i].charAt(j);
          if(ts == 'L' || ts == 'M'|| ts == 'R'){
            cats[count][0] = i;
            cats[count][1] = j;
            count++;
          }
        }
      }

      for(int i = 0; i < count; i++){
        
        for(int j = i + 1; j < count; j++){
          int dx = cats[i][0] - cats [j][0];
          int dy = cats[i][1]- cats [j][1];          
          double dis = (int) Math.sqrt(dx * dx + dy * dy);
          
          if(dis < minDistance){
           return false; 
          }
            
        }
      }
        
      return true;
    }
