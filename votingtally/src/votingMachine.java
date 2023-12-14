public class votingMachine {
    private int[] candidatelist;
    private int numcandidates;

    public votingMachine(int numcandidates){
        this.numcandidates= numcandidates;
        candidatelist = new int [numcandidates];
    }

    private void castvote(int candidate){
        if(candidate>-1 && candidate<numcandidates){
            candidatelist[numcandidates]++;
        }
    }

    private int countvotes(int candidatechoice){
        if(candidatechoice>-1 && candidatechoice<numcandidates){
            return(candidatelist[whowon(candidatechoice)]);
        }else{
            return 0;
        }
    }

    private int whowon(int candidatechoice){
        int maxval = 0;
        int max=0;
        if(candidatechoice>-1 && candidatechoice<numcandidates){
            for (int i = 0; i <candidatelist.length; i++) {
                if(candidatelist[i]>maxval){
                    maxval = candidatelist[i];
                    max = i;
                }
            }
        }return max;
    }
}
