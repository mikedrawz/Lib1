# Lib1

This library is part of a dependency issue that I am having when trying to reference common code
from one KMM library in another. So far I only notice it when the library I am importing has an
android target.

To reproduce this issue do the following:
1. Checkout this project (https://github.com/mikedrawz/Lib1.git)
2. Run the following gradle tasks `./gradlew clean assemble publishToMavenLocal`
3. Checkout the the partner project (https://github.com/mikedrawz/Lib2.git)
4. Notice under the `Project` tab, in `External Libraries` that there is a library for the JVM
target, but not the common. For me this shows as `Gradle: com.example.mdrawz:Lib1-jvm:1.0-SNAPSHOT`

What is even more so odd, is that when I import the kermit library two libraries show up
* `Gradle: co.touchlab:kermit:commonMain:1.2.2`
* `Gradle: co.touchlab:kermit-jvm:1.2.2`

I would expect `Lib1` to also have a commonMain lib, but for some reason it doesn't resolve, and
when I check the generated jars I can see a meta-inf and a sources jar. The latter has the common 
code and the former has some KMM config stuff.

Right now I'm a bit lost as to why I am unable to resolve the common module. I'm sure its a 
configuration somewhere, but for the life of me I cannot find it.