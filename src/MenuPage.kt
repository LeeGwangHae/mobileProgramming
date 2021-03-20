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

        val user = userInfo.searchByGameID()
        val ranking = user?.ranking

        if(user != null){
            println("$user's Ranking : $ranking")
        }else{
            println("User No Exist")
        }
    }

    fun menuThree(){
        val user = userInfo.searchByGameID()
        val rating = user?.tier

        if(user != null){
            println("$user's Tier : Challenger $rating")
        }else{
            println("User No Exist")
        }
    }

    fun menuFour(){

    }

    fun menuFive(){

    }

    fun menu(){
        while(true){
            println("#########################")
            println("1. User Information")
            println("2. Most Win User")
            println("3. Highest WinRate User")
            println("4. Game User Played")
            println("5. Find User Team")
            println("0. Exit")
            println("#########################")
            print("Input menu number want to use : ")
            var menuNum = scan.nextInt()
            println()

            if(menuNum == 0){
                break;
            }else{
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