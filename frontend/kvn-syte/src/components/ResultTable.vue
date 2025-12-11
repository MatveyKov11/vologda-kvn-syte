<template>
    <div class="ui text container">
        <h2 class="ui header">
            <div class="content">
                Результаты игры
            </div>
        </h2>
    </div>
    <table class="ui table">
        <thead><tr>
            <th>Название команды</th>
            <th v-for="i in columns.length" :key="i">
                <form class="ui form">
                    <div class="field">
                        <select class="ui fluid dropdown" v-model="columns[i-1]">
                            <option disabled value="">Конкурс</option>
                            <option v-for="contest in contests" :key="contest.id" :value="contest.contestName">{{ contest.contestName }}</option>
                        </select>
                    </div>
                </form>
            </th>
            <th> Всего</th>
            <th><i class="plus icon" @click="addColumn()"></i></th>
        </tr></thead>
        <tbody>
            <tr v-for="result in results" :key="result.id">
                <td>
                    <form class="ui form">
                        <div class="field">
                            <select class="ui fluid dropdown" v-model="result.team">
                                <option disabled value="">Команда</option>
                                <option v-for="team in teams" :key="team.id" :value="team.teamName">{{ team.teamName }}</option>
                            </select>
                        </div>
                    </form>
                </td>
                <td v-for="i in result.rates.length" :key="i">
                    <div class="ui fluid input">
                        <input type="number" :name="'rate'+i" v-model="result.rates[i-1]">
                    </div>
                </td>
                <td> {{ sumFinal(result.rates) }}</td>
                <td><i class="minus square icon" @click="deleteRow(result.id)"></i></td>
            </tr>
            <tr>
                <td></td>
                <td v-for="i in columns.length" :key="i" align="center">
                    <div class="ui icon fluid button" @click="deleteColumn(i-1)">
                        <i class="minus square icon"></i>
                        Удалить
                    </div>
                </td>
                <td></td>
                <td></td>
            </tr>
        </tbody>
    </table>
    <button class="ui button" @click="addRow">
        <i class="plus icon"></i> Добавить команду
    </button>
    <button class="ui button" @click="saveChanges">
        <i class="check icon"></i> Сохранить изменения
    </button>
</template>

<script setup>
import router from '@/router';
import { ref } from 'vue';

const contests = ref([
    {
        id: 0,
        contestName: 'Визитка'
    },
    {
        id: 1,
        contestName: 'Разминка'
    },
    {
        id: 2,
        contestName: 'Сложная ситуация'
    },
    {
        id: 3,
        contestName: 'Музыкальное домашнее задание'
    }
])

const teams = ref([
    {
        id: 0,
        teamName: '35 Элемент',
        capitanFio: 'Маслов Всеволод',
        capitanContacts: '-'
    },
    {
        id: 1,
        teamName: 'Люди ФСИНем',
        capitanFio: 'Калантаев Симеон',
        capitanContacts: '-'
    },
    {
        id: 2,
        teamName: 'Хлорид Натрия',
        capitanFio: 'Лощилова Анна',
        capitanContacts: '-'
    }
])

const columns = ref([
    'Визитка', 'Разминка', 'Сложная ситуация'
])

const results = ref([
    {
        id: 0,
        team: '35 Элемент',
        rates: [5, 5, 5]
    },
    {
        id: 1,
        team: 'Хлорид Натрия',
        rates: [5, 4, 5]
    }
])

function sumFinal(arr){
    let s = 0
    for(let i = 0; i < arr.length; i++){
        s += arr[i]
    }
    return s
}

function deleteRow(id){
    results.value = results.value.filter(el => el.id != id)
    for(let i = 0; i < results.value.length; i++){
        results.value[i].id = i
    }
}

function addRow(){
    let res = []
    for(let i = 0; i < columns.value.length; i++){
        res.push(0)
    }
    results.value.push({id: results.value.length, team: '', rates: res})
}

function addColumn(){
    columns.value.push('')
    for(let i = 0; i < results.value.length; i++){
        results.value[i].rates.push(0)
    }
}

function deleteColumn(id){
    for(let i = id; i < columns.value.length-1; i++){
        columns.value[i] = columns.value[i+1].slice()
        for(let j = 0; j < results.value.length; j++){
            results.value[j].rates[i] = results.value[j].rates[i+1]
        }
    }
    columns.value.pop()
    for(let i = 0; i < results.value.length; i++){
        results.value[i].rates.pop()
    }
}

function saveChanges(){
    alert('Изменения сохранены!')
    router.push({name: 'Admin Home'})
}
</script>