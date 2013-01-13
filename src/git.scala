import scala.git.Repository

object git {
    def main(args: Array[String])={
        val git_repo_path = "/home/paulhsu/j2ee_workspace/scala-git"
        var gitRepo = new Repository(git_repo_path)
        println(gitRepo.toString())
    }
}