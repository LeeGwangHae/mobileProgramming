import java.io.File
import java.util.*

class UserManager constructor(val txtPath: String = "./user.txt"){
    val userList = mutableListOf<User>()
    val scanUser = Scanner(File(this.txtPath))
    val input = Scanner(System.`in`)

    fun readFile() : List<User>{
        while(this.scanUser.hasNext()){
            val str = this.scanUser.nextLine()
            val line = str.split(", ")

            this.userList.add(User(line[0].toInt(), line[1], line[2].toInt(), line[3].toInt(), line[4].toInt(), line[5].toDouble(), line[6]))
        }

        return this.userList
    }

    fun foundUser(){

    }

    fun searchByGameID(): User?{//1-1
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

    fun searchByRanking(): User?{//1-2
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

    fun isHeProGamer() : String?{//6
        readFile()

        print("Input Game ID to check ProGamer : ")
        val id = input.nextLine()
        var proAma : String? = null
        for(i in userList){
            if(i.gameID == id){
                proAma = i.proAma
            }
        }
        return proAma
    }

}