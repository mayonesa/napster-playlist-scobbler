import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.dsl.DSL.Parse._

object NapsterPlaylistParser extends App {
  private val playlistHtml = JsoupBrowser().parseFile("src/main/resources/bruni.html")
  private val (songs, artists) = playlistHtml >> (extractor(".name", texts), extractor(".artist a", texts))
  println(s"list of songs: ${songs.size} ${artists.size}")
  songs.zip(artists).foreach { case (song, artist) =>
    println(s"$song $artist")
  }
}