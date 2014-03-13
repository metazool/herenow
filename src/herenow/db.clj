(ns herenow.db
  (:require [environ.core :refer [env]]
            [monger.core :as mg]
            monger.joda-time
            [monger.collection :as mc]
            [monger.query :as mq]))

(def db-uri (env :db-uri))

(mg/connect-via-uri! db-uri)

;; User
;; Schema = {
;;   _id: ObjectId(),
;;   text: 'what was written in the textarea',
;;   terms: ['auto','extracted','words and phrases'],
;;   created: Date(),
;;
;; }

(defn create-issue[& {:keys [text]}]
  (let [doc {
         :_id  
         :text text
         :created (util/datetime)}]
    (try
      (do
        (mc/insert "issue" doc)
        true)
      (catch Exception e false))))



(defn get-issue [id]
  (let [user (mc/find-one-as-map "issue" {:_id id})]
    (if (not (nil? user))
      {:id (issue :_id)
       :text (issue :name)
       :created (issue :created)
       :terms (issue :terms)}
      nil)))


