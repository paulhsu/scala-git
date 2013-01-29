package scala.git

object GitObjType extends Enumeration {
        type GitObjType = Value
        val Commit = Value("commit")
        val Tree = Value("tree")
        val Tag = Value("tag")
        val Blob = Value("blob")
}