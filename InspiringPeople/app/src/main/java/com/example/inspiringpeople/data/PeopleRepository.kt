package com.example.inspiringpeople.data

import com.example.inspiringpeople.model.InspiringPerson

object PeopleRepository
{
    private val people = mutableListOf<InspiringPerson>(
        InspiringPerson(
            1,
            "Nikola Tesla",
            "7 January 1943",
            "Nikola Tesla was a Serbian-American inventor, electrical engineer, mechanical engineer, " +
                    "and futurist best known for his contributions to the design of the modern alternating current " +
                    "(AC) electricity supply system.",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/N.Tesla.JPG/220px-N.Tesla.JPG"),
        InspiringPerson(
            2,
            "Albert Einstein",
            "14 March 1879",
            "Albert Einstein was a German-born theoretical physicist, widely acknowledged to be one of the greatest " +
                    "physicists of all time. Einstein is known for developing the theory of relativity, but he also made" +
                    " important contributions to the development of the theory of quantum mechanics." +
                    " Relativity and quantum mechanics are together the two pillars of modern physics." +
                    " His mass–energy equivalence formula E = mc2, which arises from relativity theory, " +
                    "has been dubbed \"the world's most famous equation\". His work is also known for its influence " +
                    "on the philosophy of science. He received the 1921 Nobel Prize in Physics \"for his " +
                    "services to theoretical physics, and especially for his discovery of the law of the photoelectric " +
                    "effect\", a pivotal step in the development of quantum theory. His intellectual achievements and" +
                    " originality resulted in \"Einstein\" becoming synonymous with \"genius\".",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Einstein_1921_by_F_Schmutzer_-_restoration.jpg/220px-Einstein_1921_by_F_Schmutzer_-_restoration.jpg"),
        InspiringPerson(
            3,
            "Mike Tyson",
            "June 30, 1966",
            "Michael Gerard Tyson is an American former professional boxer who competed from 1985 to 2005. " +
                    "Nicknamed \"Iron Mike\"[3] and \"Kid Dynamite\" in his early career, and later known as \"The Baddest Man" +
                    " on the Planet\", Tyson is considered one of the best heavyweight boxers of all time." +
                    " He reigned as the undisputed world heavyweight champion from 1987 to 1990. Tyson won his " +
                    "first 19 professional fights by knockout, 12 of them in the first round. Claiming his first " +
                    "belt at 20 years, four months, and 22 days old, Tyson holds the record as the youngest boxer to " +
                    "win a heavyweight title. He was the first heavyweight boxer to simultaneously hold the WBA," +
                    " WBC and IBF titles, as well as the only heavyweight to unify them in succession. The following year, " +
                    "Tyson became the lineal champion when he knocked out Michael Spinks in 91 seconds of the first round. In 1990, " +
                    "Tyson lost the titles to underdog Buster Douglas in one of the biggest upsets in history, when he was " +
                    "knocked out in the tenth round.",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e1/Mike_Tyson_2019_by_Glenn_Francis.jpg/220px-Mike_Tyson_2019_by_Glenn_Francis.jpg"),
        InspiringPerson(
            4,
            "Elon Musk",
            "June 28, 1971",
            "Elon Reeve Musk FRS is a business magnate, industrial designer, and engineer." +
                    " He is the founder, CEO, CTO, and chief designer of SpaceX; early stage investor," +
                    " CEO, and product architect of Tesla, Inc.; founder of The Boring Company; co-founder of Neuralink;" +
                    " and co-founder and initial co-chairman of OpenAI. A centibillionaire, Musk is one of the richest" +
                    " people in the world.\n" +
                    "\n" +
                    "Musk was born to a Canadian mother and South African father and raised in Pretoria" +
                    ", South Africa. He briefly attended the University of Pretoria before moving to Canada aged 17" +
                    " to attend Queen's University. He transferred to the University of Pennsylvania two years later," +
                    " where he received dual bachelor's degrees in economics and physics. He moved to California in " +
                    "1995 to attend Stanford University but decided instead to pursue a business career, co-founding " +
                    "the web software company Zip2 with his brother Kimbal. The startup was acquired by Compaq for " +
                    "\$307 million in 1999. Musk co-founded online bank X.com that same year," +
                    " which merged with Confinity in 2000 to form the company PayPal and was subsequently bought " +
                    "by eBay in 2002 for \$1.5 billion.",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/85/Elon_Musk_Royal_Society_%28crop1%29.jpg/220px-Elon_Musk_Royal_Society_%28crop1%29.jpg")
    )

    fun getPeople(): List<InspiringPerson> = people
    fun getPerson(name: String): InspiringPerson = people.first { it -> it.name == name }
    fun insert(person: InspiringPerson) = people.add(person)
    fun delete(person: InspiringPerson) = people.remove(person)

}