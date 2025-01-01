# My Resume
My resume, written in Kotlin. This project uses kotlinx-html, kotlinx-css, and kotlinx-io to build my real resume. This can be viewed on the web in your browser (click here) or printed to a PDF for distribution. Effort was taken to ensure the resume prints to PDF/Paper nicely as this is the main use case.

The resume is specific to me but is essentially a DSL that builds on kotlinx-html and kotlinx-css to make web content which is then written to files using kotlinx-io. I am working on a static content generator for Kotlin and this was a good use case for such a project. I hope to preserve this as an example usage of this project showcasing what sorts of problems it could solve.

Please note that this is just a personal utility and not something designed for mass consumption. If you attempt to build this source code you'll be missing libraries such as `statik-core` which is another thing I am currently working on. In reality all `statik-core` does is write the HTML/CSS to files in the target directory specified in `Main.kt`. 

## Why do this?
As I mentioned above, I am creating a "static content generator" in Kotlin. I have long been frustrated by markup languages being loosely typed and lacking the control structures needed to avoid repeating myself constantly. There are many template languages like Jinja2, JSX, Liquid, that attempt to solve this but those are untyped and often lack the full functionality of their parent programming language. I believe Kotlin is somewhat unique in that it's expressive enough to generate content with _no template language at all_ and hope to build a project based on this idea.

I also just needed a new resume and found this to be a fun challenge. I had originally made my resume in LaTeX but thought I could achieve the same thing with HTML/CSS and learn something with more broad use cases.