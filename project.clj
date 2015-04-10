(defproject zenerator "0.1.0"
  :repl-options {:init-ns zenerator.repl}
  :dependencies [[org.clojure/clojure "1.7.0-alpha6"]
                 [ring-server "0.4.0"]
                 [lib-noir "0.9.9"]
                 [com.cemerick/url "0.1.1"]
                 [noir-exception "0.2.3"]
                 [environ "1.0.0"]
                 [clj-time "0.9.0"]
                 [im.chit/cronj "1.4.3"]
                 [com.taoensso/timbre "3.4.0"]
                 [prone "0.8.1"]
                 [selmer "0.8.2"]
                 [org.clojure/clojurescript "0.0-3195"]
                 [reagent "0.5.0"]
                 [cljs-ajax "0.3.11"]
                 [secretary "1.2.3"]
                 [com.ashafa/clutch "0.4.0"]
                 [couchbase-clj "0.2.0"]
                 [http-kit "2.1.16"]
                 [expectations "2.1.0"]]
  
  :cljsbuild {:builds
              [{:source-paths ["src-cljs"],
                :compiler {:pretty-print true,
                           :output-dir "resources/public/js/",
                           :source-map true,
                           :output-to "resources/public/js/app.js",
                           :optimizations :none},
                :id "dev"}
               {:source-paths ["src-cljs"],
                :compiler {:pretty-print false,
                           :closure-warnings {:non-standard-jsdoc :off},
                           :output-to "resources/public/js/app.js",
                           :output-wrapper false,
                           :optimizations :advanced},
                :id "prod"}]}
  :ring {:handler zenerator.handler/app,
         :init zenerator.handler/init,
         :destroy zenerator.handler/destroy}
  :profiles {:uberjar {:aot :all},
             :production
             {:ring
              {:open-browser? false, :stacktraces? false, :auto-reload? false}},
             :dev
             {:dependencies [[ring-mock "0.1.5"]
                             [ring/ring-devel "1.3.2"]
                             [pjstadig/humane-test-output "0.7.0"]],
              :injections [(require 'pjstadig.humane-test-output)
                           (pjstadig.humane-test-output/activate!)],
              :env {:dev true}}}
  :url "http://example.com/FIXME"
  :main zenerator.core
  :jvm-opts ["-server"]
  :plugins [[lein-ring "0.9.3"]
            [codox "0.8.11"]
            [lein-expectations "0.0.8"]
            [lein-environ "1.0.0"]
            [lein-cljsbuild "1.0.5"]
            [lein-autoexpect "1.4.2"]]
  :description "FIXME: write description"
  :min-lein-version "2.0.0")
