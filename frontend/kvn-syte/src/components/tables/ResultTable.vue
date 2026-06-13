<template>
    <div class="ui text container">
        <h2 class="ui header">
            <div class="content">
                Результаты игры
            </div>
        </h2>
    </div>
    <div class="ui hidden divider"></div>
    <div class="ui input">
        <input type="text" name="name" v-model="tableTitle" placeholder="Название таблицы">
    </div>
    <table class="ui table">
        <thead><tr>
            <th>Название команды</th>
            <th v-for="i in results.columns.length" :key="i">
                <div class="ui fluid input">
                    <input type="text" name="contest" v-model="results.columns[i-1]" placeholder="Название конкурса">
                </div>
            </th>
            <th> Всего</th>
            <th>
                <div class="ui icon green button" @click="addColumn()">
                    <i class="plus icon"/>
                </div>
            </th>
        </tr></thead>
        <tbody>
            <tr v-for="(row, i) in results.rows" :key="i" @mouseover="row.isVisible = true" @mouseleave="row.isVisible = false">
                <td>
                    <div class="ui fluid input">
                        <input type="text" name="team" v-model="row.team">
                    </div>
                </td>
                <td v-for="(rate, j) in row.rates" :key="j">
                    <div class="ui fluid input">
                        <input type="number" :name="'rate'+j" v-model="row.rates[j]">
                    </div>
                </td>
                <td> {{ sumFinal(row.rates) }}</td>
                <td>
                    <div class="ui icon red button" @click="deleteRow(i)" v-if="row.isVisible">
                        <i class="x icon"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td/>
                <td v-for="i in results.columns.length" :key="i" align="center">
                    <div class="ui icon fluid red button" @click="deleteColumn(i)">
                        <i class="x icon"/>
                        Удалить
                    </div>
                </td>
                <td/>
                <td/>
            </tr>
        </tbody>
    </table>
    <button class="ui primary button" @click="addRow">
        <i class="plus icon"/> Добавить команду
    </button>
    <button class="ui green button" @click="saveChanges">
        <i class="check icon"/> Сохранить изменения
    </button>
    <button class="ui button" @click="lookTable">
        <i class="eye icon"/> Предпросмотр таблицы
    </button>
    <TableWindow :tableId="-1" :table="table" v-if="isLook" @quit="isLook = false; table = {columns: [], rows: []}"/>
</template>

<script setup>
import router from '@/router';
import { ref } from 'vue';
import TableWindow from '../windows/TableWindow.vue';

const props = defineProps({
    table: {
        type: Object,
        required: true
    }
})

const results = ref({
    columns: ['Визитка', 'Разминка', 'Сложная ситуация'],
    rows: [
    {
        team: '35 Элемент',
        rates: [5, 5, 5],
        isVisible: false
    },
    {
        team: 'Хлорид Натрия',
        rates: [5, 4, 5],
        isVisible: false
    }]
})
const tableTitle = ref("")
const table = ref({
    title: "",
    columns: [],
    rows: []
})
const isLook = ref(false)

if (props.table){
    results.value = JSON.parse(JSON.stringify(props.table.results))
    tableTitle.value = ''+props.table.title
}

function sumFinal(arr){
    let s = 0
    arr.forEach(el => {
        s += el
    })
    return s
}

function deleteRow(r){
    let resultsCopy = {
        columns: results.value.columns,
        rows: []
    }
    for(let i = 0; i < results.value.rows.length; i++){
        if(i != r){
            resultsCopy.rows.push(results.value.rows[i])
        }
    }
    results.value = resultsCopy
}

function addRow(){
    let res = []
    for(let i = 0; i < results.value.columns.length; i++){
        res.push(0)
    }
    results.value.rows.push({rates: res})
}

function addColumn(){
    results.value.columns.push('')
    results.value.rows.forEach(row => {
        row.rates.push(0)
    })
}

function deleteColumn(c){
    let columnsCopy = []
    for(let i = 0; i < results.value.columns.length; i++){
        if(i != c){
            columnsCopy.push(results.value.columns[i])
        }
    }

    let resultsCopy = {
        columns: columnsCopy,
        rows: []
    }
    for(let i = 0; i < results.value.rows.length; i++){
        resultsCopy.rows.push({
            team: results.value.rows[i].team,
            rates: [],
            isVisible: false
        })
        for(let j = 0; j < results.value.columns.length; j++){
            if(j != c){
                resultsCopy.rows[i].rates.push(results.value.rows[i].rates[j])
            }
        }
    }
    results.value = resultsCopy
}

function saveChanges(){
    alert('Заглушка! Изменения сохранены!')
    router.push({name: 'Admin Home'})
}

function lookTable(){
    table.value.title = tableTitle.value

    table.value.columns.push("Название команды")
    results.value.columns.forEach(col => {
        table.value.columns.push(col)
    })
    table.value.columns.push("Всего")

    results.value.rows.forEach((row, i) => {
        table.value.rows.push([row.team])
        row.rates.forEach(rate => {
            table.value.rows[i].push(rate)
        })
        table.value.rows[i].push(sumFinal(row.rates))
    })

    isLook.value = true
}
</script>