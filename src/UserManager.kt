import java.io.File
import java.util.*

class UserManager constructor(val txtPath: String = "./user.txt"){
    val userList = mutableListOf<User>()
    val proList = mutableListOf<User>()
    val nonProList = mutableListOf<User>()
    val scanUser = Scanner(File(this.txtPath))
    val input = Scanner(System.`in`)


    fun readFile() : List<User>{
        while(this.scanUser.hasNext()){
            val str = this.scanUser.nextLine()
            val line = str.split(", ")

            this.userList.add(User(line[0].toInt(), line[1], line[2].toInt(), line[3].toInt(), line[4].toInt(), line[5].toDouble(), line[6], line[7]))
        }
        return this.userList
    }

    fun searchByGameID(): User?{
        readFile()
        print("Input User ID : ")
        val id = input.nextLine()
        var foundUser : User? = null
        for (i in userList){
            if(i.gameID == id){
                foundUser = i
            }
        }
        return foundUser
    }

    fun searchByRanking(): User?{
        readFile()
        print("Input User Ranking : ")
        val ranking = input.nextInt()
        var foundUser : User? = null
        for (i in userList){
            if(i.ranking == ranking){
                foundUser = i
            }
        }
        return foundUser
    }

    fun divideGamer(){
        readFile()
        this.proList.clear()
        this.nonProList.clear()
        for(i in this.userList){
            if(i.proAma == "Pro"){
                this.proList.add(i)
            }else{
                this.nonProList.add(i)
            }
        }
    }

    fun proGamerTeam(teamName : String) : List<User>{
        val playerList = mutableListOf<User>()
        for(i in this.proList){
            if(i.team == teamName){
                playerList.add(i)
            }
        }
        return playerList
    }

    fun sortByWinrate(list:List<User>){
        var winrates = mutableListOf<Pair<User,Double>>()
        for(i in list){
            val Tuple = Pair(i,i.winRate)
            winrates.add(Tuple)
        }
        var sorted = quickSortforDouble(winrates)
        for(i in sorted){
            println("${i.component1().gameID},${i.component2()}%")
        }
    }

    fun sortByWin(list:List<User>){
        var win = mutableListOf<Pair<User,Int>>()
        for(i in list){
            val Tuple = Pair(i,i.win)
            win.add(Tuple)
        }
        var sorted = quickSortforInt(win)
        for(i in sorted){
            println("${i.component1().gameID}, ${i.component2()}승")
        }
    }
    fun quickSortforInt(list:List<Pair<User,Int>>):List<Pair<User,Int>>{
        if(list.size < 2 ) return list

        //Any become Number, Integer Or Double.
        val middle = list[list.size/2]
        val pivot = middle.component2()
        // Recursive Quick Sort
        val left = list.filter { it.component2() > pivot }
        val right = list.filter { it.component2() < pivot }

        return quickSortforInt(left) + listOf(middle) + quickSortforInt(right)
    }

    fun quickSortforDouble(list:List<Pair<User,Double>>):List<Pair<User,Double>>{
        if(list.size < 2 ) return list

        //Any become Number, Integer Or Double.
        val middle = list[list.size/2]
        val pivot = middle.component2()
        // Recursive Quick Sort
        val left = list.filter { it.component2() > pivot }
        val right = list.filter { it.component2() < pivot }

        return quickSortforDouble(left) + listOf(middle) + quickSortforDouble(right)
    }

}