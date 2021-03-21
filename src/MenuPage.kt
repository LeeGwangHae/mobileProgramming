import java.util.*

class MenuPage {
    val userInfo = UserManager()
    val scan = Scanner(System.`in`)

    fun menuOne(){

        var user : User? = null

        println("#########################")
        println("1. Find By Game ID")
        println("2. Find By Ranking")
        println("#########################")
        print("Input menu number want to use : ")
        var menuNum = scan.nextInt()

        when(menuNum){
            1 -> user = userInfo.searchByGameID()
            2 -> user = userInfo.searchByRanking()
        }

        val id = user?.gameID
        val ranking = user?.ranking
        val rating = user?.tier
        val win = user?.win
        val lose = user?.lose
        val winRate = user?.winRate
        val proAma = user?.proAma

        if(user != null){
            println("Ranking : $ranking, ID : $id, Tier : Chanllenger $rating, Win : $win, Lose : $lose, Win Rate : $winRate, Progamer : $proAma")
        }else{
            println("User No Exist")
        }
    }
    fun menuTwo(){
        userInfo.sortByWin(userInfo.readFile())
    }

    fun menuThree(){
        userInfo.sortByWinrate(userInfo.readFile())
    }

    fun menuFour(){
        userInfo.divideGamer()

        print("Input team (T1, DK, GEN, BRO, NS, AF) : ")
        scan.nextLine()
        var teamName = scan.nextLine()

        if(teamName == "T1" || teamName == "DK" || teamName == "GEN" || teamName == "BRO" || teamName == "NS" || teamName == "AF"){
            val playerList = userInfo.proGamerTeam(teamName)
            println("Team Name : $teamName")
            for(i in playerList){
                println("${i.gameID}")
            }
        }else{
            println("No such Team name in data")
        }

    }

    fun menuFive(){
        userInfo.divideGamer()
        val nonProList = userInfo.nonProList
        for(i in nonProList){
            println("${i.gameID}")
        }

    }

    fun menu(){
        while(true){
            println("#########################")
            println("1. User Information")
            println("2. Descending Order by Win")
            println("3. Descending Order by Win Rate")
            println("4. Find Pro-Gamer")
            println("5. Find Non-Pro-Gamer")
            println("0. Exit")
            println("#########################")
            print("Input menu number want to use : ")
            var menuNum = scan.nextInt()
            println()

            if(menuNum == 0){
                break;
            }else if(menuNum < 0 || menuNum > 5){
                println("Wrong Menu Number. Input again")
            }
            else{
                when(menuNum){
                    1 -> menuOne()
                    2 -> menuTwo()
                    3 -> menuThree()
                    4 -> menuFour()
                    5 -> menuFive()
                }
            }
        }// while finish
    }
}