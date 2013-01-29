import scala.git.Repository
import com.jcraft.jzlib.InflaterInputStream
import com.jcraft.jzlib.Inflater
import java.io.FileInputStream
import java.io.File
import com.jcraft.jzlib.ZInputStream
import java.io.ByteArrayInputStream
import java.io.ObjectInputStream


object git {
    def main(args: Array[String])={
        //val git_repo_path = "/home/paulhsu/j2ee_workspace/scala-git"
        //var gitRepo = new Repository(git_repo_path)
        //println(gitRepo.toString())
        val iis =  new InflaterInputStream(new FileInputStream(new File(
                "/home/paulhsu/eclipse_android_web/android_workspace/Lucy/.git/objects/ae/eb1665ed69f94a4372bf48eddea2c7cce785bc")))
        var byte: Array[Byte] = new Array[Byte](2048)
        var cnt = iis.read(byte,0,2048)
        for(f<-byte)
            print(f.toChar)
        //println("cnt:" + cnt)
        //println(byte.toString())

//        var input_s = new FileInputStream("/home/paulhsu/eclipse_android_web/android_workspace/Lucy/.git/objects/ae/eb1665ed69f94a4372bf48eddea2c7cce785bc")
//        var bytes = input_s.toString().getBytes();
//        var buf_ins = new ByteArrayInputStream(bytes)
//        var zin = new ZInputStream(buf_ins)
//        var objIn = new ObjectInputStream(zin);
//        println(objIn.readObject());

    }
}